package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        boolean p1moved = false;
        boolean p2moved = false;
        while (matches > 0) {
            if (p1moved == false || p2moved == true) {
                System.out.println("Первый игрок берет от 1 до 3 спичек");
                int move = Integer.valueOf(input.nextLine());
                if (move >= 1 && move <= 3) {
                    matches -= move;
                    p1moved = true;
                    p2moved = false;
                } else {
                    System.out.println("от 1 до 3х!");
                    p2moved = true;
                }
                if (matches <= 0) {
                    System.out.println("Разобраны все спички. Победил первый игрок!");
                    break;
                }
                System.out.println("Осталось " + matches + " спичек");
            }
            if (p2moved == false || p1moved == true) {
                System.out.println("Второй игрок берет от 1 до 3 спичек");

                int move2 = Integer.valueOf(input.nextLine());
                if (move2 >= 1 && move2 <= 3) {
                    matches -= move2;
                    p2moved = true;
                    p1moved = false;
                } else {
                    System.out.println("От 1 до 3х!");
                    p1moved = true;
                }
                if (matches <= 0) {
                    System.out.println("Разобраны все спички. Победил второй игрок!");
                    break;
                }
                System.out.println("Осталось " + matches + " спичек");
            }
        }
    }
}
