package pro.sky.springcalculatordemo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.springcalculatordemo.exceptions.DivisionByZeroException;
import pro.sky.springcalculatordemo.exceptions.NotNumbersException;
import pro.sky.springcalculatordemo.exceptions.NumbersNotFoundException;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    public CalculatorController(CalculatorService calculatorService) {

        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greet() {
        return calculatorService.hello();
    }

    @GetMapping (path = "/plus")
    public String summarise(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(StringUtils.isAnyBlank(num1,num2)) {
            throw new NumbersNotFoundException("Для сложения необходимы 2 числа");
        }
        return calculatorService.plus(num1,num2);
    }

    @GetMapping (path = "/minus")
    public String subtraction(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(StringUtils.isAnyBlank(num1,num2)) {
            throw new NumbersNotFoundException("Для вычитания необходимы 2 числа");
        }
        return calculatorService.minus(num1,num2);
    }

    @GetMapping (path = "/multiply")
    public String multiply(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(StringUtils.isAnyBlank(num1,num2)) {
            throw new NumbersNotFoundException("Для умножения необходимы 2 числа");
        }
        return calculatorService.multiply(num1,num2);
    }

    @GetMapping (path = "/divide")
    public String divide(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if(StringUtils.isAnyBlank(num1,num2)) {
            throw new NumbersNotFoundException("Для деления необходимы 2 числа");
        }
        return calculatorService.divide(num1,num2);
    }

    @ExceptionHandler(NumbersNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String numbersNotFoundExceptionHandler(NumbersNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(DivisionByZeroException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String divisionByZeroExceptionHandler(DivisionByZeroException e) {
        return e.getMessage();
    }

    @ExceptionHandler(NotNumbersException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String notNumbersExceptionHandler(NotNumbersException e) {
        return e.getMessage();
    }

}
