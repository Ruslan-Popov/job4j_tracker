package ru.job4j.tracker;

import java.util.List;

public class SearchItemsWithNameAction implements UserAction {
    private final Output out;

    public SearchItemsWithNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String itemSearched = input.askStr("Enter name of the item to search");
        List<Item> itemsFound = tracker.findByName(itemSearched);
        if (itemsFound.size() != 0) {
            out.println("Found " + itemSearched + " with IDs:");
            for (int i = 0; i < itemsFound.size(); i++) {
                out.println(itemsFound.get(i).getId());
            }
        } else {
            out.println("There is no items with such name");
        }
        return true;
    }
}
