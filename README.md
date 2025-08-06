# RSA Cryptography Implementation

A Java implementation of the RSA (Rivest-Shamir-Adleman) public-key cryptographic algorithm for educational purposes.

## 📋 Overview

This project implements a basic RSA encryption and decryption system that demonstrates the fundamental concepts of public-key cryptography. The program generates RSA key pairs, encrypts plaintext messages, and decrypts cipher text back to the original message.

## 🔐 How RSA Works

RSA is an asymmetric cryptographic algorithm that uses a pair of keys:
- **Public Key**: Used for encryption (can be shared publicly)
- **Private Key**: Used for decryption (must be kept secret)

### Key Generation Process

1. **Select two prime numbers** (p and q)
2. **Calculate n = p × q** (modulus for both keys)
3. **Calculate φ(n) = (p-1) × (q-1)** (Euler's totient function)
4. **Choose e** such that 1 < e < φ(n) and gcd(e, φ(n)) = 1 (public exponent)
5. **Calculate d** such that d × e ≡ 1 (mod φ(n)) (private exponent)

## 🚀 Features

- **Prime Number Generation**: Finds the largest prime number below a given upper limit
- **RSA Key Pair Generation**: Automatically generates public and private keys
- **Text Encryption**: Encrypts plaintext messages using the public key
- **Text Decryption**: Decrypts cipher text using the private key
- **Modular Exponentiation**: Efficient implementation for large number computations
- **Interactive Console Interface**: User-friendly command-line interaction

## 🛠️ Technical Implementation

### Core Components

- **Prime Detection**: `isPrime()` method to verify prime numbers
- **GCD Calculation**: Greatest Common Divisor using iterative approach
- **Modular Exponentiation**: `modExp()` for efficient large number exponentiation
- **Key Generation**: Automated RSA parameter calculation
- **Encryption/Decryption**: Character-by-character processing

### Key Variables

- `p, q`: Two distinct prime numbers
- `n`: Modulus (p × q)
- `m`: φ(n) = (p-1) × (q-1)
- `e`: Public exponent
- `d`: Private exponent
- `c[]`: Array to store encrypted values

## 📖 Usage

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE or command-line compiler

### Running the Program

1. **Compile the Java file:**
   ```bash
   javac src/Main.java
   ```

2. **Run the program:**
   ```bash
   java -cp src Main
   ```

3. **Follow the interactive prompts:**
   - Enter upper limits for prime numbers p and q
   - Enter your message to encrypt
   - View the generated keys, encrypted message, and decrypted result

### Example Usage

```
Enter TWO distinct upper limits for the two primes q , p :
upper limit for p : 50
upper limit for q : 30
p: 47
q: 29
n : 1363
m : 1288
e : 3
d : 859
Enter original message : Hello
cipher message : 
[encrypted output]
decrypted message : 
Hello
```

## 🔧 Code Structure

```
CryptoGraphy/
├── src/
│   └── Main.java          # Main implementation file
├── CryptoGraphy.iml       # IntelliJ IDEA module file
└── README.md              # This file
```

### Method Breakdown

| Method | Purpose |
|--------|---------|
| `getP(long k)` | Find largest prime ≤ k for p |
| `getQ(long k)` | Find largest prime ≤ k for q |
| `getGCD(long x, long y)` | Calculate Greatest Common Divisor |
| `getE()` | Find public exponent e |
| `getD()` | Calculate private exponent d |
| `getN()` | Calculate modulus n |
| `getM()` | Calculate φ(n) |
| `encryption()` | Encrypt plaintext message |
| `decryption()` | Decrypt cipher text |
| `modExp()` | Modular exponentiation |
| `isPrime(long n)` | Prime number verification |

## ⚠️ Important Notes

### Security Considerations

This implementation is for **educational purposes only** and should **NOT** be used for actual secure communications because:

1. **Small Key Sizes**: Uses small prime numbers for demonstration
2. **Simplified Implementation**: Lacks proper padding schemes (OAEP, PKCS#1)
3. **No Random Number Generation**: Uses deterministic prime selection
4. **Character-based Encryption**: Encrypts individual characters rather than blocks
5. **No Input Validation**: Minimal error handling and input sanitization

### Limitations

- **Prime Finding Algorithm**: Uses a simple trial division method (inefficient for large numbers)
- **GCD Calculation**: Basic iterative approach (not optimized)
- **Memory Usage**: Fixed-size array limits message length to 1000 characters
- **Performance**: Not optimized for speed or large-scale operations

## 🎓 Educational Value

This project demonstrates:

- **Public-key cryptography concepts**
- **Mathematical foundations of RSA**
- **Prime number theory applications**
- **Modular arithmetic operations**
- **Algorithm implementation in Java**

## 🔮 Potential Improvements

- Implement more efficient prime generation algorithms (Miller-Rabin test)
- Add proper padding schemes for security
- Use BigInteger for handling larger key sizes
- Implement key file storage and loading
- Add comprehensive error handling
- Create a graphical user interface
- Optimize algorithms for better performance

## 📚 References

- [RSA Algorithm on Wikipedia](https://en.wikipedia.org/wiki/RSA_(cryptosystem))
- [Introduction to Modern Cryptography by Katz and Lindell](https://www.cs.umd.edu/~jkatz/imc.html)
- [Applied Cryptography by Bruce Schneier](https://www.schneier.com/books/applied-cryptography/)

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

Created for educational purposes to demonstrate RSA cryptography implementation in Java.

---

**Disclaimer**: This implementation is for learning purposes only. For production use, always rely on well-tested cryptographic libraries and frameworks.
