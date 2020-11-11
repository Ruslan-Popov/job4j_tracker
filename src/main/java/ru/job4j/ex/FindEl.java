package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element with such name not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] names = {"Igor", "Den", "Vasya"};
            System.out.println(indexOf(names, "Mitya"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
