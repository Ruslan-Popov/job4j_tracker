package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class FlatMapUseTest {
    @Test
    public void whenFlatMap() {
        Integer[][] ints = {
                {1, 2},
                {3, 4}
        };
        List<Integer> rst = FlatMapUse.convert(ints);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(rst, is(expected));
    }
}