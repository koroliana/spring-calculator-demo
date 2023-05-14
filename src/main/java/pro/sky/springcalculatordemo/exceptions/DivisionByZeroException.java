package pro.sky.springcalculatordemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DivisionByZeroException extends IllegalArgumentException{
    private final String message;

    public DivisionByZeroException(String message)    {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
