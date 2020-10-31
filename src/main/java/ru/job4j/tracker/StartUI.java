//package ru.job4j.tracker;
//
//import java.util.Scanner;
//
//public class StartUI {
//
//    public void init(Scanner scanner, Tracker tracker) {
//        boolean run = true;
//        while (run) {
//            this.showMenu();
//            int select = Integer.valueOf(scanner.nextLine());
//            switch (select) {
//                case 0:
//                    System.out.println("=== Create a new item ====");
//                    System.out.println("Enter name: ");
//                    String name = scanner.nextLine();
//                    Item item = new Item(name);
//                    tracker.add(item);
//                case 1:
//
//                case 6: run = false;
//                default:
//                    System.out.println("Enter value from 0 to 6");
//        }
//    }
//
//    private void showMenu() {
//        System.out.println("Menu");
//        System.out.println("0. Add new item");
//        System.out.println("1. Show all items");
//        System.out.println("2. Edit item");
//        System.out.println("3. Delete item");
//        System.out.println("4. Find item by id");
//        System.out.println("5. Find items by name");
//        System.out.println("6. Exit program");
//        System.out.println("Select:");
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Tracker tracker = new Tracker();
//        new StartUI().init(scanner, tracker);
//    }
//}
