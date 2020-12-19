package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void whenSort() {
        List<Item> items = Arrays.asList(
                new Item(3, "Item3"),
                new Item(1, "Item1"),
                new Item(10, "Item10")
        );
        Collections.sort(items);
        List<Item> expected = Arrays.asList(
                new Item(1, "Item1"),
                new Item(3, "Item3"),
                new Item(10, "Item10")
        );
        assertThat(items, is(equalTo(expected)));
    }

    @Test
    public void whenReverseSort() {
        List<Item> items = Arrays.asList(
                new Item(3, "Item3"),
                new Item(1, "Item1"),
                new Item(10, "Item10")
        );
        Collections.sort(items, new ReverseSortedItem());
        List<Item> expected = Arrays.asList(
                new Item(10, "Item10"),
                new Item(3, "Item3"),
                new Item(1, "Item1")
        );
        assertThat(items, is(equalTo(expected)));
    }
}