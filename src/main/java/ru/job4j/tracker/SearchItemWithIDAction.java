package ru.job4j.tracker;

public class SearchItemWithIDAction implements UserAction {
    private final Output out;

    public SearchItemWithIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idSearched = input.askInt("Enter ID of the item to search");
        Item itemFoundByID = tracker.findById(idSearched);
        if (itemFoundByID != null) {
            out.println("Found " + itemFoundByID.getName() + ", ID " + idSearched);
        } else {
            out.println("There is no item with such ID");
        }
        return true;
    }
}
