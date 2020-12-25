package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] l = left.split("\\. ", 2);
        String[] r = right.split("\\. ", 2);
        int leftInt = Integer.parseInt(l[0]);
        int rightInt = Integer.parseInt(r[0]);
        return Integer.compare(leftInt, rightInt);
//        String[] lNums = l[0].split("\\.");
//        String[] rNums = r[0].split("\\.");
//        for (int i = 0; i < Math.min(lNums.length, rNums.length); i++) {
//            int leftInt = Integer.parseInt(lNums[i]);
//            int rightInt = Integer.parseInt(rNums[i]);
//            int rsl = Integer.compare(leftInt, rightInt);
//            if (rsl != 0) {
//                return rsl;
//            }
//        }
//        return Integer.compare(lNums.length, rNums.length);
    }
}
