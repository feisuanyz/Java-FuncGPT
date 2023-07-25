
```
import java.math.BigDecimal;

public class BigDecimalExpressionCalculator {
    public static BigDecimal calculateExpression(String expression) {
        // 去除空格
        expression = expression.replaceAll("\\s+", "");

        // 使用递归方法计算表达式
        return calculate(expression);
    }

    private static BigDecimal calculate(String expression) {
        if (expression.length() == 0) {
            return BigDecimal.ZERO;
        }

        // 处理括号
        if (expression.contains("(")) {
            int startIndex = expression.lastIndexOf("(");
            int endIndex = expression.indexOf(")", startIndex);

            String subExpression = expression.substring(startIndex + 1, endIndex);
            BigDecimal result = calculate(subExpression);

            expression = expression.substring(0, startIndex) + result.toString()
                    + expression.substring(endIndex + 1);

            return calculate(expression);
        }

        // 处理乘法和除法
        if (expression.contains("*") || expression.contains("/")) {
            int index = 0;

            if (expression.contains("*")) {
                index = expression.indexOf("*");
            } else if (expression.contains("/")) {
                index = expression.indexOf("/");
            }

            BigDecimal leftOperand = new BigDecimal(expression.substring(0, index));
            BigDecimal rightOperand = new BigDecimal(expression.substring(index + 1));

            if (expression.charAt(index) == '*') {
                return calculate(leftOperand.multiply(rightOperand).toString());
            } else {
                return calculate(leftOperand.divide(rightOperand, BigDecimal.ROUND_HALF_UP).toString());
            }
        }

        // 处理加法和减法
        if (expression.contains("+") || expression.contains("-")) {
            int index = 0;

            if (expression.contains("+")) {
                index = expression.indexOf("+");
            } else if (expression.contains("-")) {
                index = expression.indexOf("-");
            }

            BigDecimal leftOperand = new BigDecimal(expression.substring(0, index));
            BigDecimal rightOperand = new BigDecimal(expression.substring(index + 1));

            if (expression.charAt(index) == '+') {
                return leftOperand.add(rightOperand);
            } else {
                return leftOperand.subtract(rightOperand);
            }
        }

        // 处理纯数字
        return new BigDecimal(expression);
    }

    public static void main(String[] args) {
        String expression = "(2.5 * 4 + 3) / 2 - 1.5";
        BigDecimal result = calculateExpression(expression);
        System.out.println(expression + " = " + result);
    }
}

```
