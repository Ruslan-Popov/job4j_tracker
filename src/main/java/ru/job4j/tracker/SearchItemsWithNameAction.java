package ru.job4j.tracker;

public class SearchItemsWithNameAction implements UserAction {
    @Override
    public String name() {
        return "==== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
