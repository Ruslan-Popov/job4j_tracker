package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapUse {
    public static void main(String[] args) {
        Integer[][] ints = {
                {1, 2},
                {3, 4}
        };
        List<Integer> rst = Stream.of(ints)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(rst);
    }
}