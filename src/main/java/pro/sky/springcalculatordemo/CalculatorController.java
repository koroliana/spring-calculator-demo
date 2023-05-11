package pro.sky.springcalculatordemo;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.*;
import pro.sky.springcalculatordemo.exceptions.NumbersNotFoundException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final CustomExceptionResolver customExceptionResolver;
    public CalculatorController(CalculatorService calculatorService, CustomExceptionResolver customExceptionResolver) {

        this.calculatorService = calculatorService;
        this.customExceptionResolver = customExceptionResolver;
    }



    private boolean isNull(String a, String b){
        return a == null || b == null;
    }


    @GetMapping
    public String greet() {
        return calculatorService.hello();
    }

    @GetMapping (path = "/plus")
    public String summarise(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(isNull(num1,num2)) {
            return "Для сложения необходимы 2 числа";
        }
        return calculatorService.plus(num1,num2);
    }

    @GetMapping (path = "/minus")
    public String subtraction(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(isNull(num1,num2)) {
            return "Для вычитания необходимы 2 числа";
        }
        return calculatorService.minus(num1,num2);
    }

    @GetMapping (path = "/multiply")
    public String multiply(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(isNull(num1,num2)) {
            return "Для умножения необходимы 2 числа";
        }
        return calculatorService.multiply(num1,num2);
    }

    @GetMapping (path = "/divide")
    public String divide(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(isNull(num1,num2)) {
            return "Для деления необходимы 2 числа";
        }
        return calculatorService.divide(num1,num2);
    }

    /*
    @GetMapping(value = "/testExceptionHandler", produces = APPLICATION_JSON_VALUE)
    public Response testExceptionHandler(@RequestParam(required = false, defaultValue = "false") boolean exception)
            throws NumbersNotFoundException {
        if (exception) {
            throw new NumbersNotFoundException("BusinessException in testExceptionHandler");
        }
        return new Response(200);
    }

    @ExceptionHandler(NumbersNotFoundException.class)
    public Response numbersNotFoundExceptionHandler(NumbersNotFoundException e) {
        return new Response(404);
    }


     */


}
