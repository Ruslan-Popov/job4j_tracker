package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Choose command");
            if (select == 0) {
                System.out.println("==== Create a new item ====");
                System.out.println("Enter name: ");
                String name = input.askStr("Enter name");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    System.out.println("Item " + (i + 1) + ": " + items[i].getName() + ", id: " + items[i].getId());
                }
            } else if (select == 2) {
                System.out.println("Enter ID of item you want to change");
                int id = input.askInt("Enter ID");
                System.out.println("Enter new element name");
                String name = input.askStr("Enter name");
                Item item = new Item(id, name);
                if (tracker.replace(id, item)) {
                    System.out.println("Replaced!");
                } else {
                    System.out.println("ID not found");
                }
            } else if (select == 3) {
                System.out.println("Enter ID of item you want to delete");
                int id = input.askInt("Enter ID");
                if (tracker.delete(id)) {
                    System.out.println("Deleted!");
                } else {
                    System.out.println("ID not found");
                }
            } else if (select == 4) {
                System.out.println("Enter ID of the item to search");
                int idSearched = input.askInt("Enter ID");
                Item itemFoundByID = tracker.findById(idSearched);
                if (itemFoundByID != null) {
                    System.out.println("Found " + itemFoundByID.getName() + ", ID " + idSearched);
                } else {
                    System.out.println("There is no item with such ID");
                }
            } else if (select == 5) {
                System.out.println("Enter name of the item to search");
                String itemSearched = input.askStr("Enter name");
                Item[] itemsFound = tracker.findByName(itemSearched);
                if (itemsFound.length != 0) {
                    System.out.println("Found " + itemSearched + " with IDs:");
                    for (int i = 0; i < itemsFound.length; i++) {
                        System.out.println(itemsFound[i].getId());
                    }
                } else {
                    System.out.println("There is no items with such name");
                }
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Enter value from 0 to 6");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
        System.out.println("Select:");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}