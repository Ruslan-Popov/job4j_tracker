package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "==== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID of item you want to delete");
        if (tracker.delete(id)) {
            System.out.println("Deleted!");
        } else {
            System.out.println("ID not found");
        }
        return true;
    }
}
