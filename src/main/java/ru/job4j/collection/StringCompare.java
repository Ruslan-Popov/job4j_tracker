package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < left.length(); i++) {
            if (i > right.length() - 1) {
                return 1;
            }
            char l = left.charAt(i);
            char r = right.charAt(i);
            if (l < r) {
                return -1;
            }
            if (l > r) {
                return 1;
            }
            if (i == left.length() - 1 && right.length() > left.length()) {
                return -1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("Ivanov".compareTo("Ivanova"));
//        System.out.println("Ivan".charAt(4));
    }
}