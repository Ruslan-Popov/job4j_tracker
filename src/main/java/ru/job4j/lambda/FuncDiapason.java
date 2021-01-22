package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FuncDiapason {
    public static List<Double> diapason (int start, int end, Function<Double, Double> function) {
        List<Double> nums = new ArrayList<>();
        for (double d = start; d < (double) end; d++) {
            nums.add(function.apply(d));
        }
        return nums;
    }
}
