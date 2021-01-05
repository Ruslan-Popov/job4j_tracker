package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashSet;

public class Retelling {
    public static boolean generateBy(String originText, String duplicateText) {
        boolean rsl = true;
        String[] orig = originText.split(" |\\r?\\n|,|\\.|!|;");
        String[] dupl = duplicateText.split(" ");
        HashSet<String> temp = new HashSet<>();
        for (String origWord : orig) {
            temp.add(origWord);
        }
        for (String word: dupl) {
            if (!temp.contains(word)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
