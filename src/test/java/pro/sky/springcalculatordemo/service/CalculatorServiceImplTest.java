package pro.sky.springcalculatordemo.service;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.springcalculatordemo.exceptions.DivisionByZeroException;
import pro.sky.springcalculatordemo.exceptions.NotNumbersException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorServiceImplTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();
    private final String numberFive = "5";
    private final String numberNull = "0";
    private final String stringFive = "five";
    private final String stringNull = null;


/*
    @BeforeEach //Почему-то не срабатывает
    public void setUp(){
        //CalculatorService calculatorService = new CalculatorServiceImpl();
        //String numberFive = "5";
        String numberNull = "0";
        String stringFive = "five";
        String stringNull = null;
    }

 */

    @Test
    public void plusTest() {
        String expected = calculatorService.plus(numberFive,numberFive);
        double sum = Double.parseDouble(numberFive)+Double.parseDouble(numberFive);
        String actual = numberFive + " + " + numberFive + " = " + (int) sum;
        assertEquals(expected,actual);

        String expected2 = calculatorService.plus("-5","8");
        String actual2 = "-5 + 8 = 3";
        assertEquals(expected2,actual2);

    }

    @Test
    public void minusTest() {
        String expected = calculatorService.minus(numberFive,numberFive);
        double res = Double.parseDouble(numberFive)-Double.parseDouble(numberFive);
        String actual = numberFive + " - " + numberFive + " = " + (int) res;
        assertEquals(expected,actual);

        String expected2 = calculatorService.minus("-5","8");
        String actual2 = "-5 - 8 = -13";
        assertEquals(expected2,actual2);

    }

    @Test
    public void multiplyTest() {
        String expected = calculatorService.multiply(numberFive,numberFive);
        double res = Double.parseDouble(numberFive)*Double.parseDouble(numberFive);
        String actual = numberFive + " * " + numberFive + " = " + (int) res;
        assertEquals(expected,actual);

        String expected2 = calculatorService.multiply("-5","8");
        String actual2 = "-5 * 8 = -40";
        assertEquals(expected2,actual2);

    }

    @Test
    public void divideTest() {
        String expected = calculatorService.divide(numberFive,numberFive);
        double res = Double.parseDouble(numberFive)/Double.parseDouble(numberFive);
        String actual = numberFive + " / " + numberFive + " = " + res;
        assertEquals(expected,actual);

        String expected2 = calculatorService.divide("-5","8");
        String actual2 = "-5 / 8 = -0.625";
        assertEquals(expected2,actual2);

    }

    @Test
    public void divideNegativeTest() {
        Assertions.assertThrows(DivisionByZeroException.class, () -> calculatorService.divide(numberFive,numberNull));
        Assertions.assertThrows(DivisionByZeroException.class, () -> calculatorService.divide("-5","0"));

        Assertions.assertThrows(NotNumbersException.class, () -> calculatorService.divide(numberFive,stringFive));
        Assertions.assertThrows(NotNumbersException.class, () -> calculatorService.divide("-5","one"));
    }

    @Test
    public void plusNegativeTest() {
        Assertions.assertThrows(NotNumbersException.class, () -> calculatorService.plus(numberFive,stringFive));
        Assertions.assertThrows(NotNumbersException.class, () -> calculatorService.plus("-5","one"));
    }

    @Test
    public void minusNegativeTest() {
        Assertions.assertThrows(NotNumbersException.class, () -> calculatorService.minus(numberFive,stringFive));
        Assertions.assertThrows(NotNumbersException.class, () -> calculatorService.minus("-5","one"));
    }

    @Test
    public void multiplyNegativeTest() {
        Assertions.assertThrows(NotNumbersException.class, () -> calculatorService.multiply(numberFive,stringFive));
        Assertions.assertThrows(NotNumbersException.class, () -> calculatorService.multiply("-5","one"));
    }



}
