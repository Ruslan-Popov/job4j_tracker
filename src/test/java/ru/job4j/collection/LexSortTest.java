package ru.job4j.collection;

import java.util.Arrays;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] output = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(output));
    }

    @Test
    public void sortNumsWithDots() {
        String[] input = {
                "10.3.4. Task.",
                "10.3.1. Task.",
                "1000.1. Task.",
                "8. Task."
        };
        String[] output = {
                "8. Task.",
                "10.3.1. Task.",
                "10.3.4. Task.",
                "1000.1. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(output));
    }
}