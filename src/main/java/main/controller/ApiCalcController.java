package main.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import main.config.SwaggerConfig;
import main.service.CalcService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Api(tags = {SwaggerConfig.CALC_TAG})
@Validated
public class ApiCalcController {

  private final CalcService calcService;

  @GetMapping("/addition")
  @ApiOperation("Сложение")
  public ResponseEntity<?> addition(
      @RequestParam @Valid @NotEmpty BigDecimal num1,
      @RequestParam @Valid @NotEmpty BigDecimal num2) {
    return ResponseEntity.ok(calcService.function(num1, num2, "addition"));
  }

  @GetMapping("/subtraction")
  @ApiOperation("Вычитание")
  public ResponseEntity<?> subtraction(
      @RequestParam @Valid @NotEmpty BigDecimal num1,
      @RequestParam @Valid @NotEmpty BigDecimal num2) {
    return ResponseEntity.ok(calcService.function(num1, num2, "subtraction"));
  }

  @GetMapping("/multiplication")
  @ApiOperation("Умножение")
  public ResponseEntity<?> multiplication(
      @RequestParam @Valid @NotEmpty BigDecimal num1,
      @RequestParam @Valid @NotEmpty BigDecimal num2) {
    return ResponseEntity.ok(calcService.function(num1, num2, "multiplication"));
  }

  @GetMapping("/division")
  @ApiOperation("Деление")
  public ResponseEntity<?> division(
      @RequestParam @Valid @NotEmpty BigDecimal num1,
      @RequestParam @Valid @NotEmpty BigDecimal num2) {
    try {
      return ResponseEntity.ok(calcService.function(num1, num2, "division"));
    } catch (ArithmeticException e) {
      return ResponseEntity.ok("You can't divide by 0!");
    } catch (IllegalStateException ex) {
      return ResponseEntity.ok("Error in the 'function' parameter, contact the developer");
    }
  }
}
