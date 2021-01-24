package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>(
                Arrays.asList(10, -1, -3, 8, 13)
        );
        List<Integer> newAl = aList.stream().filter(
                list -> list > 0
        ).collect(Collectors.toList());
        newAl.forEach(System.out::println);
    }
}
