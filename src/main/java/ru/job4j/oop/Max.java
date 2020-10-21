package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        boolean leftMax = left > right;
        int result = leftMax ? left : right;
        return result;
    }

    public static int max(int first, int second, int third) {
        int tmp = max(first, second);
        int result = max(tmp, third);
        return result;
    }

    public static int max(int first, int second, int third, int fourth) {
        int tmp = max(first, second, third);
        int result = max(tmp, fourth);
        return result;
    }
}