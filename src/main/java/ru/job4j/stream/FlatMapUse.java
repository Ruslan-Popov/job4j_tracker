package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapUse {

    public static List<Integer> convert(Integer[][] oldList) {
        return Stream.of(oldList)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}