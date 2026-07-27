# Base Number System Converter

## Overview

This Java program converts numbers between different number systems. It supports conversions between bases **2–10** and **16**, including numbers with **fractional (decimal) parts**.

The program first converts the input into base 10 and then converts the result into the desired target base.

## Features

* Convert numbers between:

  * Binary (Base 2)
  * Octal (Base 8)
  * Decimal (Base 10)
  * Hexadecimal (Base 16)
  * Any base from **2–10**
* Supports numbers with decimal points (e.g. `101.101`, `A3.F`)
* Handles hexadecimal digits `A–F`
* Validates user input for supported bases
* Provides error messages for invalid bases or unsupported hexadecimal characters

## How It Works

The program follows a two-step conversion process:

1. **Convert the input number to base 10**

   * Whole numbers are converted using positional notation.
   * Fractional values are converted using negative powers of the original base.

2. **Convert the base 10 value to the target base**

   * Whole numbers are converted using repeated division.
   * Fractional values are converted using repeated multiplication.

## Supported Bases

| Base  | Supported |
| ----- | --------- |
| 2–10  | Yes       |
| 11–15 | No        |
| 16    | Yes       |

Hexadecimal values use the characters:

* A = 10
* B = 11
* C = 12
* D = 13
* E = 14
* F = 15

## Example

**Input**

```
Enter a number (can include a decimal point) to convert:
1011.101

Enter the current base of your previous input
2

Enter the target base you want to convert your string into
10
```

**Output**

```
Your number converted to base 10 is 11.625
```

## Project Structure

| Method                  | Purpose                                                         |
| ----------------------- | --------------------------------------------------------------- |
| `hasDecimalPoint()`     | Converts numbers with fractional parts into base 10             |
| `convertToBase10()`     | Converts whole numbers into base 10                             |
| `convertToTargetBase()` | Converts whole base 10 numbers into another base                |
| `convertDecimal()`      | Converts decimal (fractional) base 10 numbers into another base |
| `baseCheck()`           | Validates that the entered base is supported                    |
| `main()`                | Handles user input and controls the conversion process          |

## Limitations

* Only supports bases **2–10** and **16**.
* Hexadecimal input must use uppercase letters (`A–F`).
* Negative numbers are not supported.
* Fractional conversions may produce repeating values depending on the target base and floating-point precision.

## Requirements

* Java Development Kit (JDK) 8 or later

## Running the Program

Compile the program:

```bash
javac App.java
```

Run the program:

```bash
java App
```

Follow the prompts to enter:

1. The number to convert
2. Its current base
3. The target base

The program will then display the converted value.
