package calculatorTest;

import block1.calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;


public class CalcTest {

    private static Calculator calculator;


    @BeforeAll
    public static void init() {
        calculator = new Calculator();
        System.out.println("Tests begin.");
    }

    @Test
    @DisplayName("Test addition 12 + 3")
    public void testAddition() {
        System.out.println("Test 1");
        int result = calculator.addition(12, 3);
        Assertions.assertEquals(15, result, "Result is wrong: " + result);
    }

    @Test
    @DisplayName("Test subtraction 98 - 9")
    public void testSubtraction() {
        System.out.println("Test 2");
        int result = calculator.subtraction(98, 9);
        Assertions.assertFalse(result == 56, "Result is wrong: " + result);
    }

    @ParameterizedTest
    @MethodSource("integerStreamProvide")
    @DisplayName("Parameterized test")
    public void testMultiplication(int a, int b, int expected) {
        System.out.println("Test 3");
        int result = calculator.multiplication(a, b);
        Assertions.assertEquals(result, expected, "Result is wrong: " + result);
        List.of("String")
                .stream()
                .collect(Collectors.toList());
    }

    public static Stream<Arguments> integerStreamProvide() {
        return Stream.of(
                Arguments.arguments(2, 4, 8),
                Arguments.arguments(10, 20, 200),
                Arguments.arguments(23, 20, 460));
    }

    @Test
    @DisplayName("Test division 25 / 5")
    public void testDivision() {
        System.out.println("Test 4");
        int result = calculator.division(25, 5);
        Assertions.assertTrue(result == 5, "Result is wrong: " + result);


    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Tests are PASSED.");
    }


}
