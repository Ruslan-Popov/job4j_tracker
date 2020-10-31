package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        boolean p1moved = false;
        while (matches > 0) {
            if (!p1moved) {
                System.out.println("Первый игрок берет от 1 до 3 спичек");
                int move = Integer.valueOf(input.nextLine());
                if (move >= 1 && move <= 3) {
                    matches -= move;
                    p1moved = !p1moved;
                } else {
                    System.out.println("от 1 до 3х!");
                }
                if (matches <= 0) {
                    System.out.println("Разобраны все спички. Победил первый игрок!");
                    break;
                }
                System.out.println("Осталось " + matches + " спичек");
            }
            if (p1moved) {
                System.out.println("Второй игрок берет от 1 до 3 спичек");
                int move2 = Integer.valueOf(input.nextLine());
                if (move2 >= 1 && move2 <= 3) {
                    matches -= move2;
                    p1moved = !p1moved;
                } else {
                    System.out.println("От 1 до 3х!");
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
