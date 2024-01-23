import java.util.Scanner;

public class Main {
    static private final double[] c = new double[1000];
    static long q, p, n, m, e, d;
    static String pl, ci, pl2;
    static int asc;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter TWO distinct upper limits for the two primes q , p : ");
        System.out.print("upper limit for p : ");
        getP(scan.nextLong());
        System.out.print("upper limit for q : ");
        getQ(scan.nextLong());
        prep();
        System.out.println("p: " + p + "\nq: " + q + "\nn : " + n + "\nm : " + m + "\ne : " + e + "\nd : " + d);
        System.out.print("Enter original message : ");
        pl = scan.nextLine();
        pl = scan.nextLine();
        System.out.println("cipher message : ");
        encryption();
        System.out.println("decrypted message : ");
        decryption();

    }

    public static void getP(long k) {
        while (isPrime(k)) k--;
        p = k;
    }

    public static void getQ(long k) {
        while (isPrime(k)) k--;
        q = k;
    }

    public static long getGCD(long x, long y) {
        long gcd = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if ((x % i == 0 && y % i == 0)) gcd = i;
        }
        return gcd;
    }

    public static void getE() {
        for (int i = 2; ; i++) {
            if (getGCD(m, i) == 1) {
                e = i;
                break;
            }
        }


    }

    public static void getN() {
        n = q * p;
    }

    public static void getM() {
        m = (p - 1) * (q - 1);
    }

    public static void getD() {
        for (int i = 0; ; i++) {
            if ((m * i + 1) % e == 0) {
                d = (m * i + 1) / e;
                break;
            }

        }
    }

    public static void prep() {
        getN();
        getM();
        getE();
        getD();
    }

    @SuppressWarnings("StringConcatenationInLoop")
    private static void encryption() {
        ci = "";
        for (int i = 0; i < pl.length(); i++) {
            asc = pl.charAt(i);
            c[i] = modExp(asc, e, n);
            ci += (char) (c[i] % 256);
        }
        System.out.println(ci);
    }

    @SuppressWarnings("StringConcatenationInLoop")
    private static void decryption() {
        pl2 = "";
        for (int i = 0; i < pl.length(); i++) {
            long c_i = (long) c[i];
            long m_i = modExp(c_i, d, n);
            pl2 += (char) m_i;
        }
        System.out.println(pl2);
    }

    private static long modExp(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }

        return result;
    }
    static boolean isPrime(long n) {

        if (n <= 1) return true;


        for (int i = 2; i < n; i++)
            if (n % i == 0) return true;

        return false;
    }
}