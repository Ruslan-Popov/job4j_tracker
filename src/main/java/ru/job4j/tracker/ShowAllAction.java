package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        for (int i = 0; i < items.size(); i++) {
            out.println("Item " + (i + 1) + ": " + items.get(i).getName()
                    + ", id: " + items.get(i).getId());
        }
        return true;
    }
}
