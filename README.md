### Product Introduction

Describe Java function requirements using natural language and generate high-quality, readable code in real-time. The generated code can be directly copied to IDEA or imported into Java ADT's function library with one click.

#### Five Major Capabilities

● Natural Language: Functions can be generated based on natural language descriptions, reducing the barrier to software development.

● Instant Function Development: Functions can be developed in seconds, significantly improving efficiency.

● One-stop Development Application: Generated functions can be directly applied, ensuring efficiency and security.

● Reliable Quality: The generated code complies with industry standards, possesses good readability, and represents optimal solutions.

● Flexible Generation: Functions can be generated based on specific requirements and support adjustments and modifications.

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/41b74106-e4c1-4f13-b1e9-91c9fc069913)

### Comparison

Test Case: BigDecimal Expression Calculation

#### 1. Java FuncGPT vs Manual Code

|     | Java FuncGPT                | Manual Code                           |
|-----|-----------------------------|------------------------------------|
| Time  | 23 seconds                     | 7 days                               |
| Readability | Good readability, reasonable naming conventions, clear and concise comments   | Poor readability, non-standard naming conventions, unclear comments    |
| Conciseness | Simple algorithm, appropriate data structure and algorithms used, avoiding complex nested logic and multiple conditions | Lack of conciseness, code with layers of nesting, cumbersome methods, not conducive to later maintenance and modification |
| Robustness | Handles null values, good robustness and reliability  | Low robustness, no null value handling  |

Source Code：[Java FuncGPT: BigDecimal Expression Calculation](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/Java%20FuncGPT%3A%20BigDecimal%20Expression%20Calculation.md) | [Manual Code: BigDecimal Expression Calculation](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/Manual%20Code%3A%20BigDecimal%20Expression%20Calculation.md)

#### 2. Java FuncGPT vs ERNIE Bot

|     | Java FuncGPT                    | ERNIE Bot                                       |
|-----|---------------------------------|------------------------------------------------|
| Time  | 25 seconds                  | 1 minutes                                   |
| Flexibility | Good flexibility and extensibility, uses a stack data structure to handle operators and numbers in expressions | Less flexibility, poor extensibility, calculates expressions step by step using string splitting and loops|
| Robustness | Handles null values, good robustness and reliability   | Low robustness, no null value handling     |
| Comprehensiveness | Supports handling parentheses | Does not support handling parentheses  |

Source Code：[Java FuncGPT: BigDecimal Expression Calculation](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/Java%20FuncGPT%3A%20BigDecimal%20Expression%20Calculation.md) | [ERNIE Bot: BigDecimal Expression Calculation](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/ERNIE%20Bot%3A%20BigDecimal%20Expression%20Calculation.md)

#### 3. Java FuncGPT vs ChatGPT-4

|     | Java FuncGPT                   | ChatGPT-4                                           |
|-----|---------------------------------|------------------------------------------------|
| Time  | 25 seconds                  | 21 seconds                                    |
| Simplicity | Clear and concise code implementation, different logical functions encapsulated in independent functions, making the code structure more clear, easy to understand, and maintain | Recursive implementation process is more cumbersome and prone to errors|
| Robustness | Good robustness and reliability, provides exception handling mechanism | Insufficient robustness, does not provide exception handling mechanism   |

Source Code：[Java FuncGPT: BigDecimal Expression Calculation](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/Java%20FuncGPT%3A%20BigDecimal%20Expression%20Calculation.md) | [ChatGPT-4: BigDecimal Expression Calculation](https://github.com/feisuanyz/Java-FuncGPT/blob/main/Test%20Case%20Src/ChatGPT-4%3A%20BigDecimal%20Expression%20Calculation.md)

### User Guide

Friendly Reminder:

a) Java FuncGPT currently only supports usage within Java Automated Development Tool. Please download the [Java Automated Development Tool](https://github.com/feisuanyz/Java-ADT/tree/main#java-automated-development-tooljava-adt) and complete registration.

b) If you have already logged into Java ADT, check in to receive Java FuncGPT credits.

#### 1. Generating Functions Based on Natural Language

a) Click on Function Library at the top of the main page.

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/ccef44de-ccd3-4eae-897c-ffa4f597973d)

b) Click on Write Function in the upper right corner to enter WEB-IDE.

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/83d9d751-a999-42f4-999d-d17d9747ed59)

c) Create a new function project.

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/71448273-2c4b-42e3-8ccc-08c46a15ce0a)

d) Fill in Java package name, project directory, and select AI Code Generation.

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/1499b4f8-aa78-4445-a3a9-4de6edf8d41f)

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/147009e6-89bb-4ba3-bef8-eb7e9e564db1)

e) (Optional) Fill in function requirement, class name, advanced options, etc., and click AI Generate Code.

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/589b22c9-3c6f-4453-b9ad-0bc0f0bd6608)

Note: a) FuncGPT (Sample).java is the AI-generated source code; b) BigDecimalExpressionCalculator.java is the code used for packaging.

#### 2. Packaging, Compilation and Upload with One-Click

a) Click on Open Maven to enter function packaging.

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/269f89c2-c362-4349-b36a-0fa8fa9b6304)

b) Click on Import Function to Platform to perform packaging.

c) Wait for package to be uploaded and confirmed.

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/50e66be0-2cbe-4486-afb9-68dde02d12e0)

#### 3. Loading Java FuncGPT in Your Project

a) Click on Project Management to return to project list page.

b) Click on the Settings and select Add-ons.

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/d2e2e47d-ac8c-4cc8-bed4-4f24ac0f8b58)

c) In the dialog box that pops up for Add-ons, select Function-Custom, and then import the previously uploaded function.

![image](https://github.com/feisuanyz/Java-FuncGPT/assets/79617492/1ebd1d4d-f2d5-4add-ae6f-57b4d9378376)

d) This function can be called by a single function component in the interface model.
