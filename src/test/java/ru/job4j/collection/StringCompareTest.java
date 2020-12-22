package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenLeftLengthGreaterResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanova",
                "Ivanov"
        );
        assertThat(rsl, greaterThan(0));
    }
}