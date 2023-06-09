package pro.sky.springcalculatordemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    private boolean isNull(String a, String b){
        return a == null || b == null;
    }


    @GetMapping (path = "/calculator")
    public String greet() {
        return calculatorService.hello();
    }

    @GetMapping (path = "/calculator/plus")
    public String summarise(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(isNull(num1,num2)) {
            return "Для сложения необходимы 2 числа";
        }
        return calculatorService.plus(num1,num2);
    }

    @GetMapping (path = "/calculator/minus")
    public String subtraction(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(isNull(num1,num2)) {
            return "Для вычитания необходимы 2 числа";
        }
        return calculatorService.minus(num1,num2);
    }

    @GetMapping (path = "/calculator/multiply")
    public String multiply(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(isNull(num1,num2)) {
            return "Для умножения необходимы 2 числа";
        }
        return calculatorService.multiply(num1,num2);
    }

    @GetMapping (path = "/calculator/divide")
    public String divide(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(isNull(num1,num2)) {
            return "Для деления необходимы 2 числа";
        }
        return calculatorService.divide(num1,num2);
    }



}
