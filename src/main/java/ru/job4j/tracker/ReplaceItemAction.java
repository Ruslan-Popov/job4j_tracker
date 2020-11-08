package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {
    private final Output out;

    public ReplaceItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID of item you want to change");
        String name = input.askStr("Enter new element name");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            out.println("Replaced!");
        } else {
            out.println("ID not found");
        }
        return true;
    }
}
