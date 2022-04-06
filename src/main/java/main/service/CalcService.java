package main.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

  private final MathContext mathContext = new MathContext(15);

  public BigDecimal function(BigDecimal num1, BigDecimal num2, String function) {
    return switch (function) {
      case "addition" -> num1.add(num2, mathContext);
      case "subtraction" -> num1.subtract(num2, mathContext);
      case "multiplication" -> num1.multiply(num2, mathContext);
      case "division" -> num1.divide(num2, 10, RoundingMode.HALF_UP);
      default -> throw new IllegalStateException("Unexpected value: " + function);
    };
  }
}
