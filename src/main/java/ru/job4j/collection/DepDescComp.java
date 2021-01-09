package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Dep = o1.split("/", 2);
        String[] o2Dep = o2.split("/", 2);
        if (!o1Dep[0].equals(o2Dep[0])) {
            return o2.compareTo(o1);
        } else {
            return o1.compareTo(o2);
        }
    }
}
