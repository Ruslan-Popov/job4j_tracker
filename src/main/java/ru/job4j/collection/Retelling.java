package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashSet;

public class Retelling {
    public static boolean generateBy(String originText, String duplicateText) {
        boolean rsl = true;
        String origWords = originText.replaceAll("\\p{P}", "");
        String duplWords = duplicateText.replaceAll("\\p{P}", "");
        String[] orig = origWords.split(" ");
        String[] dupl = duplWords.split(" ");
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
