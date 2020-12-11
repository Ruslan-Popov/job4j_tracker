package ru.job4j.list;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> result = list.toList(input);
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        assertThat(result, is(expect));
    }
}