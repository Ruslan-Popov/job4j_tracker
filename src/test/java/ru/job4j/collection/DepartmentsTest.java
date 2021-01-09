package ru.job4j.collection;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;


public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissed2() {
        List<String> input = Arrays.asList("k2/sk2", "k2/sk2/ssk2");
        List<String> expect = Arrays.asList("k2", "k2/sk2", "k2/sk2/ssk2");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortAsc() {
        List<String> input = Arrays.asList("K1/SK1/SSK2", "K2", "K1/SK1", "K1");
        List<String> expect = Arrays.asList("K1", "K1/SK1", "K1/SK1/SSK2", "K2");
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenSortDesc() {
        List<String> input = Arrays.asList("K1/SK1/SSK2", "K2", "K1/SK1", "K1", "K2/SK2", "K2/SK1");
        List<String> expect = Arrays.asList("K2", "K2/SK1", "K2/SK2", "K1", "K1/SK1", "K1/SK1/SSK2");
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }
}