package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            if (items[i] != null) {
                itemsWithoutNull[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsFoundByName = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            if (items[i].getName().equals(key)) {
                itemsFoundByName[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(itemsFoundByName, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        boolean rst = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(items[index].getId());
            items[index] = item;
            rst = true;
        }
        return rst;
    }
}