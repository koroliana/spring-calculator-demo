package pro.sky.springcalculatordemo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import pro.sky.springcalculatordemo.exceptions.DivisionByZeroException;
import pro.sky.springcalculatordemo.exceptions.NumbersNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        if (ex instanceof NumbersNotFoundException) {
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            modelAndView.addObject("message", "Для арифметического действия необходимы 2 числа");
            return modelAndView;
        } else if (ex instanceof DivisionByZeroException) {
            modelAndView.setStatus(HttpStatus.BAD_REQUEST);
            modelAndView.addObject("message", "На 0 делить нельзя!");
            return modelAndView;
        }
        //TODO это в будущем следует по-другому решить
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        modelAndView.addObject("message", "Another exception was handled");
        return modelAndView;
    }

}
