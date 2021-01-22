package ru.job4j.lambda;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FuncDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResult() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> 2 * x +1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResult() {
        List<Double> result = FuncDiapason.diapason(3, 6, x -> x * x);
        List<Double> expected = Arrays.asList(9D, 16D, 25D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResult() {
        List<Double> result = FuncDiapason.diapason(3, 6, x -> Math.pow(x,x));
        List<Double> expected = Arrays.asList(27D, 256D, 3125D);
        assertThat(result, is(expected));
    }
}