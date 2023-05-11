package pro.sky.springcalculatordemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NumbersNotFoundException extends RuntimeException {
    private final String message;

    public NumbersNotFoundException(String message)    {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
