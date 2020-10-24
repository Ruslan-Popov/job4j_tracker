package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book lionHeart = new Book("Lion Heart", 430);
        Book cleanCode = new Book("Clean code", 830);
        Book jungleBook = new Book("Junglebook", 480);
        Book godFather = new Book("The Godfather", 500);
        Book[] lib = {lionHeart, cleanCode, jungleBook, godFather};
        for (Book i : lib) {
            System.out.println(i.getName() + " - " + i.getPages());
        }
        System.out.println();
        System.out.println("Changing 1st and last books");
        Book tmp = lib[0];
        lib[0] = lib[3];
        lib[3] = tmp;
        for (Book i : lib) {
            System.out.println(i.getName() + " - " + i.getPages());
        }
        System.out.println();
        System.out.println("Showing only books called -Clean code-");
        for (Book i : lib) {
            if (i.getName().equals("Clean code")) {
                System.out.println(i.getName() + " - " + i.getPages());
            }
        }
    }
}
