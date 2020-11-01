package ru.job4j.poly;

public interface Transport {
    void go();

    void getPassengersInfo(int passengers);

    double refuel(double fuel);
}
