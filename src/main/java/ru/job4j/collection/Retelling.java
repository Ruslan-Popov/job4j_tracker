package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashSet;

public class Retelling {
    public static boolean generateBy(String originText, String duplicateText) {
        boolean rsl = true;
        String[] dupl = duplicateText.split(" ");
        for (String word: dupl) {
            if (!originText.contains(word)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
