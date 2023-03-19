package block1.main;

import block1.calculator.Calculator;

public class Main {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        boolean result = calc.multiplication(5,7)==35;

        System.out.println(result);
        System.out.println(calc.multiplication(5,7));

    }




}
