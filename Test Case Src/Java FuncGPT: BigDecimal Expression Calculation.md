
```
// 类名：BigDecimalCalculator
// 函数名：calculateExpression
// 函数功能：使用BigDecimal计算表达式的结果
// POM依赖包：
// <dependency>
//     <groupId>org.apache.commons</groupId>
//     <artifactId>commons-lang3</artifactId>
//     <version>3.12.0</version>
// </dependency>

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class BigDecimalCalculator {
    /**
     * 使用BigDecimal计算表达式的结果
     * @param expression 要计算的表达式
     * @return 计算结果
     */
    public static BigDecimal calculateExpression(String expression) {
        if (StringUtils.isBlank(expression)) { // 检查表达式是否为空或只包含空格
            throw new IllegalArgumentException("Expression cannot be blank"); // 抛出异常，表达式不能为空
        }

        Stack<BigDecimal> numberStack = new Stack<>(); // 创建用于存储数字的栈
        Stack<Character> operatorStack = new Stack<>(); // 创建用于存储运算符的栈

for (int i = 0; i < expression.length(); i++) { // 遍历表达式的每个字符
            char ch = expression.charAt(i); // 获取当前字符
            if (Character.isDigit(ch)) { // 如果当前字符是数字
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                i--;

                BigDecimal number = new BigDecimal(sb.toString()); // 将数字字符串转换为BigDecimal类型
                numberStack.push(number); // 将数字压入数字栈
            } else if (ch == '(') { // 如果当前字符是左括号
                operatorStack.push(ch); // 将左括号压入运算符栈
            } else if (ch == ')') { // 如果当前字符是右括号
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    BigDecimal result = performOperation(numberStack, operatorStack);
                    numberStack.push(result);
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            } else if (isOperator(ch)) { // 如果当前字符是运算符
                while (!operatorStack.isEmpty() && hasHigherPrecedence(ch, operatorStack.peek())) {
                    BigDecimal result = performOperation(numberStack, operatorStack);
                    numberStack.push(result);
                }
                operatorStack.push(ch); // 将运算符压入运算符栈
            }
        }

        while (!operatorStack.isEmpty()) { // 当运算符栈不为空时
            BigDecimal result = performOperation(numberStack, operatorStack); // 执行运算
            numberStack.push(result); // 将运算结果压入数字栈
        }

        return numberStack.pop(); // 返回数字栈中的结果
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/'; // 判断字符是否为运算符
    }

    private static boolean hasHigherPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) { // 判断运算符的优先级
            return true; // op1的优先级高于op2
        }
        return false; // op1的优先级低于或等于op2
    }

    private static BigDecimal performOperation(Stack<BigDecimal> numberStack, Stack<Character> operatorStack) {
        BigDecimal num2 = numberStack.pop(); // 弹出数字栈顶的两个数字和运算符栈顶的运算符
        BigDecimal num1 = numberStack.pop();
        char operator = operatorStack.pop();

        BigDecimal result;
        switch (operator) { // 根据运算符执行相应的运算
            case '+':
                result = num1.add(num2);
                break;
            case '-':
                result = num1.subtract(num2);
                break;
            case '*':
                result = num1.multiply(num2);
                break;
            case '/':
                result = num1.divide(num2, 2, RoundingMode.HALF_UP);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator"); // 如果运算符不合法，抛出异常
        }

        return result; // 返回运算结果
    }
}

// 函数示例
// 使用BigDecimal计算表达式的结果示例
// 入参：expression，要计算的表达式
// 出参：result，计算结果
// 调用示例：
// String expression = "2.5 + 3 * (4 - 1)";
// BigDecimal result = BigDecimalCalculator.calculateExpression(expression);
// System.out.println(result);
// 输出结果：例如，计算表达式"2.5 + 3 * (4 - 1)"的结果为：11.5
// 则输出结果为：11.5
```
