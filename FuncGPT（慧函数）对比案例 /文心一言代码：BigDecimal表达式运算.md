
```
import java.math.BigDecimal;  
import java.math.RoundingMode;  
  
public class BigDecimalCalculator {  
      
    public static BigDecimal calculate(String expression) {  
        String[] operators = {"+", "-", "\*", "/"};  
        BigDecimal[] numbers = expression.split("\\s+");  
        BigDecimal result = new BigDecimal(numbers[0]);  
          
        for (int i = 1; i < numbers.length; i++) {  
            for (String operator : operators) {  
                if (numbers[i].contains(operator)) {  
                    BigDecimal operand1 = new BigDecimal(numbers[i].split(operator)[0]);  
                    BigDecimal operand2 = new BigDecimal(numbers[i].split(operator)[1]);  
                    switch (operator) {  
                        case "+":  
                            result = result.add(operand1).add(operand2);  
                            break;  
                        case "-":  
                            result = result.subtract(operand1).subtract(operand2);  
                            break;  
                        case "\*":  
                            result = result.multiply(operand1).multiply(operand2);  
                            break;  
                        case "/":  
                            result = result.divide(operand1, 2, RoundingMode.HALF_UP).multiply(operand2);  
                            break;  
                    }  
                } else {  
                    result = result.add(new BigDecimal(numbers[i]));  
                }  
            }  
        }  
        return result;  
    }  
}
```
