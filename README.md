# Unpacker for Obfuscated JavaScript Code

This is a Kotlin-based utility to unpack obfuscated JavaScript code that uses specific patterns for evaluation and string splitting.

## Description

The Unpacker class provides methods to detect and unpack obfuscated JavaScript code. It searches for a specific pattern commonly used for obfuscation and attempts to reverse the obfuscation process.

## Features

- Detects the presence of obfuscated JavaScript code in the source.
- Unpacks the obfuscated JavaScript code to reveal its original content.

## Installation

Clone this repository to your local machine to get started.

```bash
git clone https://github.com/eduardomcb/Unpacker.git
```

## Usage

1. Replace `"your source code here"` in the `main()` function with the actual obfuscated JavaScript code you want to unpack.

2. Run the program:

```bash
cd Unpacker
./gradlew run
```

## Code Example

```kotlin
// Use the Unpacker class to detect and unpack obfuscated JavaScript code
val sourceCode = "your source code here"
val unpacker = Unpacker()

if (unpacker.detect(sourceCode)) {
    val unpackedCode = unpacker.unpack(sourceCode)
    println(unpackedCode)
} else {
    println("Code does not need unpacking or detection failed.")
}
```
## Contributing

Contributions are welcome! Feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
```