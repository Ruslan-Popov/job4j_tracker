package ru.job4j.oop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class PointTest {
    @Test
    public void when000to044then5dot657() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 4, 4);
        double rst = a.distance3d(b);
        assertThat(rst, closeTo(5.657, 0.001));
    }
}