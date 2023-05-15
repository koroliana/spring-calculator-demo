package pro.sky.springcalculatordemo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceImplParametrizedTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();
    public static Stream<Arguments> plusTestParams() {
        return Stream.of(
                Arguments.of("1","2","1 + 2 = 3"),
                Arguments.of("-1","2","-1 + 2 = 1"),
                //Arguments.of("null","0","NotNumbersException"),
                Arguments.of("-1","-1","-1 + -1 = -2")
        );
    }

    public static Stream<Arguments> minusTestParams() {
        return Stream.of(
                Arguments.of("1","2","1 - 2 = -1"),
                Arguments.of("-1","2","-1 - 2 = -3"),
                //Arguments.of("null","0","NotNumbersException"),
                Arguments.of("500","2","500 - 2 = 498")
        );
    }

    public static Stream<Arguments> multiplyTestParams() {
        return Stream.of(
                Arguments.of("1","2","1 * 2 = 2"),
                Arguments.of("-1","2","-1 * 2 = -2"),
                //Arguments.of("null","0","NotNumbersException"),
                Arguments.of("500","2","500 * 2 = 1000")
        );
    }

    public static Stream<Arguments> divideTestParams() {
        return Stream.of(
                Arguments.of("1","2","1 / 2 = 0.5"),
                Arguments.of("-1","2","-1 / 2 = -0.5"),
                // Arguments.of("null","0","NotNumbersException"),
                // Arguments.of("2","0","DivisionByZeroException"),
                Arguments.of("500","2","500 / 2 = 250.0")
        );
    }

    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void plusTest(String a, String b, String expected) {
        Assertions.assertThat(calculatorService.plus(a,b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void minusTest(String a, String b, String expected) {
        Assertions.assertThat(calculatorService.minus(a,b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void multiplyTest(String a, String b, String expected) {
        Assertions.assertThat(calculatorService.multiply(a,b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void divideTest(String a, String b, String expected) {
        Assertions.assertThat(calculatorService.divide(a,b))
                .isEqualTo(expected);
    }
}
