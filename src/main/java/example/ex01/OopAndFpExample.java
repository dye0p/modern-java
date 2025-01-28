package example.ex01;

public class OopAndFpExample {

    public static void main(String[] args) {
        final CalculatorService calculatorService = new CalculatorService(new Addition(), new Subtraction(),
                new Multiplication(), new Division());

        final int additionResult = calculatorService.add(20, 1);
        System.out.println(additionResult);

        final int subtractionResult = calculatorService.subtract(20, 1);
        System.out.println(subtractionResult);

        final int multiplicationResult = calculatorService.multiply(20, 1);
        System.out.println(multiplicationResult);

        final int divisionResult = calculatorService.divide(20, 4);
        System.out.println(divisionResult);

        FpCalculatorService fpCalculatorService = new FpCalculatorService();

        System.out.println("\n====객체를 주입하는 방식====");
        System.out.println("addition: " + fpCalculatorService.calculate(new Addition(), 20, 1));
        System.out.println("subtraction: " + fpCalculatorService.calculate(new Subtraction(), 20, 1));
        System.out.println("multiplication: " + fpCalculatorService.calculate(new Multiplication(), 20, 1));
        System.out.println("division: " + fpCalculatorService.calculate(new Division(), 20, 4));

        System.out.println("\n====람다식을 이용한 함수형 프로그래밍 방식====");
        System.out.println("addition: " + fpCalculatorService.calculate((i1, i2) -> i1 + i2, 20, 1));
        System.out.println("subtraction: " + fpCalculatorService.calculate((i1, i2) -> i1 - i2, 20, 1));
        System.out.println("multiplication: " + fpCalculatorService.calculate((i1, i2) -> i1 * i2, 20, 1));
        System.out.println("division: " + fpCalculatorService.calculate((i1, i2) -> i1 / i2, 20, 4));
        System.out.println("custom cal: " + fpCalculatorService.calculate((i1, i2) -> (i1 + i2) * 2 / i1, 20, 5));
    }
}

interface Calculation {
    int calculate(final int num1, final int num2);
}

class Addition implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 + num2;
    }
}

class Subtraction implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 - num2;
    }
}

class Multiplication implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 * num2;
    }
}

class Division implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 / num2;
    }
}

class CalculatorService {
    private final Calculation addition;
    private final Calculation subtraction;
    private final Calculation multiplication;
    private final Calculation division;

    public CalculatorService(Calculation addition, Calculation subtraction, Calculation multiplication,
                             Calculation division) {
        this.addition = addition;
        this.subtraction = subtraction;
        this.multiplication = multiplication;
        this.division = division;
    }

    public int add(final int num1, final int num2) {
        if (num1 > 10 && num2 < num1) {
            return addition.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }

    public int subtract(final int num1, final int num2) {
        if (num1 > 10 && num2 < num1) {
            return subtraction.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }

    public int multiply(final int num1, final int num2) {
        if (num1 > 10 && num2 < num1) {
            return multiplication.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }

    public int divide(final int num1, final int num2) {
        if (num1 > 10 && num2 < num1) {
            return division.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }
}

class FpCalculatorService {

    public int calculate(Calculation calculation, final int num1, final int num2) {
        if (num1 > 10 && num2 < num1) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + "num2: " + num2);
        }
    }
}
