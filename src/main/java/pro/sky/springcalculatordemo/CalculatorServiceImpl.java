package pro.sky.springcalculatordemo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.springcalculatordemo.exceptions.DivisionByZeroException;
import pro.sky.springcalculatordemo.exceptions.NotNumbersException;

@Service
public class CalculatorServiceImpl implements CalculatorService {


    public String hello() {
        return "Добро пожаловать в калькулятор";
    }


    public String plus(String num1, String num2) {
        if (isTwoStringsNumeric(num1,num2)) {
            double sum = Double.parseDouble(num1)+Double.parseDouble(num2);
            return num1 + " + " + num2 + " = " + (int) sum;
        }
        else throw new NotNumbersException("Калькулятор производит операцию сложения только с числами. Повторите попытку.") ;

    }

    public String minus(String num1, String num2) {
        if (isTwoStringsNumeric(num1,num2)) {
            double diff = Double.parseDouble(num1) - Double.parseDouble(num2);
            return num1 + " - " + num2 + " = " + (int) diff;
        }
        else throw new NotNumbersException("Калькулятор производит операцию вычитания только с числами. Повторите попытку.");
    }

    public String multiply(String num1, String num2) {
        if (isTwoStringsNumeric(num1,num2)) {
            double mult = Double.parseDouble(num1)*Double.parseDouble(num2);
            return num1 + " * " + num2 + " = " + (int) mult;
        }
        else throw new NotNumbersException("Калькулятор производит операцию умножения только с числами. Повторите попытку.");
    }

    public String divide(String num1, String num2) {
        if (isTwoStringsNumeric(num1,num2)) {
            double divider = Double.parseDouble(num2);
            if (divider!=0){
                double quotient = Integer.parseInt(num1)/divider;
                return num1 + " / " + num2 + " = " + (int) quotient;
            }
            else throw new DivisionByZeroException("Делить на 0 нельзя!") ;

        }
        else throw new NotNumbersException("Калькулятор производит операцию деления только с числами. Повторите попытку.");
    }

    private boolean isTwoStringsNumeric(String str1, String str2) {
        return (StringUtils.isNumeric(str1)&&StringUtils.isNumeric(str2));
    }
}
