package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker track = new Tracker();
        Item tomato = new Item(1, "Tomato");
        track.add(tomato);
        Item first = track.findById(1);
        System.out.println(first.getName());
    }
}
