package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("==== Create a new item ====");
        String name = input.askStr("Enter name");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println("Item " + (i + 1) + ": " + items[i].getName() + ", id: " + items[i].getId());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID of item you want to change");
        String name = input.askStr("Enter new element name");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            System.out.println("Replaced!");
        } else {
            System.out.println("ID not found");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID of item you want to delete");
        if (tracker.delete(id)) {
            System.out.println("Deleted!");
        } else {
            System.out.println("ID not found");
        }
    }

    public static void searchItemWithID(Input input, Tracker tracker) {
        int idSearched = input.askInt("Enter ID of the item to search");
        Item itemFoundByID = tracker.findById(idSearched);
        if (itemFoundByID != null) {
            System.out.println("Found " + itemFoundByID.getName() + ", ID " + idSearched);
        } else {
            System.out.println("There is no item with such ID");
        }
    }

    public static void searchItemsWithName(Input input, Tracker tracker) {
        String itemSearched = input.askStr("Enter name of the item to search");
        Item[] itemsFound = tracker.findByName(itemSearched);
        if (itemsFound.length != 0) {
            System.out.println("Found " + itemSearched + " with IDs:");
            for (int i = 0; i < itemsFound.length; i++) {
                System.out.println(itemsFound[i].getId());
            }
        } else {
            System.out.println("There is no items with such name");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Choose command");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.searchItemWithID(input, tracker);
            } else if (select == 5) {
                StartUI.searchItemsWithName(input, tracker);
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