package pro.sky.springcalculatordemo;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {


    public String hello() {
        return "Добро пожаловать в калькулятор";
    }


    public String plus(String num1, String num2) {
        if (isNumeric(num1)&&isNumeric(num2)) {
            double sum = Double.parseDouble(num1)+Double.parseDouble(num2);
            return num1 + " + " + num2 + " = " + sum;
        }
        else return "Передайте 2 числа";

    }

    public String minus(String num1, String num2) {
        if (isNumeric(num1)&&isNumeric(num2)) {
            double diff = Double.parseDouble(num1) - Double.parseDouble(num2);
            return num1 + " - " + num2 + " = " + diff;
        }
        else return "Передайте 2 числа";
    }

    public String multiply(String num1, String num2) {
        if (isNumeric(num1)&&isNumeric(num2)) {
            double mult = Double.parseDouble(num1)*Double.parseDouble(num2);
            return num1 + " * " + num2 + " = " + mult;
        }
        else return "Передайте 2 числа";
    }

    public String divide(String num1, String num2) {
        if (isNumeric(num1)&&isNumeric(num2)) {
            double divider = Double.parseDouble(num2);
            if (divider!=0){
                double quotient = Integer.parseInt(num1)/divider;
                return num1 + " / " + num2 + " = " + quotient;
            }
            else return "Делить на 0 нельзя!";

        }
        else return "Передайте 2 числа";
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
