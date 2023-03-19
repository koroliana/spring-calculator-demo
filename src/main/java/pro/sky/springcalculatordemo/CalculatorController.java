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
    public String summarise(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        return calculatorService.plus(num1,num2);
    }

 /*   @GetMapping (path = "/calculator/minus")
    public String warning() {
        return "Для вычитания необходимы 2 числа";
    }

  */

    @GetMapping (path = "/calculator/minus")
    public String subtraction(@RequestParam String num1, @RequestParam String num2) {
        /*
        if(num1.equals(null) || num2.equals(null)) {
            return "Для вычитания необходимы 2 числа";
        }

         */
        return calculatorService.minus(num1,num2);
    }

    @GetMapping (path = "/calculator/multiply")
    public String multiply(@RequestParam String num1, @RequestParam String num2) {
        return calculatorService.multiply(num1,num2);
    }

    @GetMapping (path = "/calculator/divide")
    public String divide(@RequestParam String num1, @RequestParam String num2) {
        return calculatorService.divide(num1,num2);
    }



}
