package pro.sky.springcalculatordemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NotNumbersException extends RuntimeException {
        private final String message;

        public NotNumbersException(String message)    {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
}
