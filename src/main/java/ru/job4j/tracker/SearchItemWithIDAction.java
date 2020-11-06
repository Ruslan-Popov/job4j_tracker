package ru.job4j.tracker;

public class SearchItemWithIDAction implements UserAction {
    @Override
    public String name() {
        return "==== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idSearched = input.askInt("Enter ID of the item to search");
        Item itemFoundByID = tracker.findById(idSearched);
        if (itemFoundByID != null) {
            System.out.println("Found " + itemFoundByID.getName() + ", ID " + idSearched);
        } else {
            System.out.println("There is no item with such ID");
        }
        return true;
    }
}
