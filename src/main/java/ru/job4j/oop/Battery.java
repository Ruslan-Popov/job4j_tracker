package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int health) {
        this.load = health;
    }

    public void exchange(Battery that) {
        this.load = this.load + that.load;
        that.load = 0;
    }

    public static void main(String[] args) {
        Battery duracell = new Battery(10);
        Battery noname = new Battery(1);
        System.out.println("Duracell: " + duracell.load + ". Noname: " + noname.load);
        duracell.exchange(noname);
        System.out.println("Duracell: " + duracell.load + ". Noname: " + noname.load);
    }
}
