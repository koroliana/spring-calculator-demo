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
            int diff = Integer.parseInt(num1) - Integer.parseInt(num2);
            return num1 + " - " + num2 + " = " + diff;
        }
        else return "Передайте 2 числа";
    }

    public String multiply(String num1, String num2) {
        int mult = Integer.parseInt(num1)*Integer.parseInt(num2);
        return num1 + " * " + num2 + " = " + mult;
    }

    public String divide(String num1, String num2) {
        double quotient = Integer.parseInt(num1)/Integer.parseInt(num2);
        return num1 + " / " + num2 + " = " + quotient;
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
