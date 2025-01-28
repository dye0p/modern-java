package example.ex01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    @Test
    void calculateAddition() throws Exception {
        Calculation calculation = new Addition();

        final int actual = calculation.calculate(1, 1);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void calculateSubtraction() throws Exception {
        Calculation calculation = new Subtraction();

        final int actual = calculation.calculate(1, 1);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void calculateMultiplication() throws Exception {
        Calculation calculation = new Multiplication();

        final int actual = calculation.calculate(2, 3);

        assertThat(actual).isEqualTo(6);
    }

    @Test
    void calculateDivision() throws Exception {
        Calculation calculation = new Division();

        final int actual = calculation.calculate(8, 4);

        assertThat(actual).isEqualTo(2);
    }

}
