package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void when354Then5() {
        int result = Max.max(3, 5, 4);
        assertThat(result, is(5));
    }

    @Test
    public void when8359Then9() {
        int result = Max.max(8, 3, 5, 9);
        assertThat(result, is(9));
    }
}