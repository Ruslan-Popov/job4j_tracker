package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> gtName =  person -> person.getName().contains(key);
        Predicate<Person> gtSurname =  person -> person.getSurname().contains(key);
        Predicate<Person> gtPhone = person -> person.getPhone().contains(key);
        Predicate<Person> gtAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = gtName.or(gtSurname).or(gtPhone).or(gtAddress);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
