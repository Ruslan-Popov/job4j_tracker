package ru.job4j.tracker;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsFoundByName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsFoundByName.add(item);
            }
        }
        return itemsFoundByName;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rst = index != -1;
        if (rst) {
            item.setId(id);
            items.set(index, item);
        }
        return rst;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rst = index != -1;
        if (rst) {
            items.remove(index);
        }
        return rst;
    }
}