package pro.sky.springcalculatordemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
    /* public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

     */

    @GetMapping (path = "/calculator")
    public String greet() {
        return calculatorService.hello();
    }

    @GetMapping (path = "/calculator/plus")
    public String summarise(@RequestParam String num1, @RequestParam String num2) {
        return calculatorService.plus(num1,num2);
    }

}
