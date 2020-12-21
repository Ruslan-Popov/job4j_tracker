package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscByPriority() {
        int rsl = new JobAscByPriority().compare(
                new Job("A job", 4),
                new Job("B job", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenDescByPriority() {
        int rsl = new JobDescByPriority().compare(
                new Job("A job", 4),
                new Job("B job", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscByName() {
        int rsl = new JobAscByName().compare(
                new Job("A job", 4),
                new Job("B job", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescByName() {
        int rsl = new JobDescByName().compare(
                new Job("A job", 4),
                new Job("B job", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareDescByNameAndAscByPriority() {
        Comparator<Job> descNameAscPrty =
                new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = descNameAscPrty.compare(
                new Job("A job", 3),
                new Job("A job", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareAscByPriorityAndAscByName() {
        Comparator<Job> ascPrtyAscName =
                new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = ascPrtyAscName.compare(
                new Job("A job", 3),
                new Job("B job", 3)
        );
        assertThat(rsl, lessThan(0));
    }
}