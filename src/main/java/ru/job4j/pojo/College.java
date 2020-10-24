package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student freshman = new Student();
        freshman.setEnrollYear(2019);
        freshman.setFullName("Ivanov Vladimir Timofeevich");
        freshman.setGroup('A');
        System.out.println("Student " + freshman.getFullName() + " has enrolled in "
                + freshman.getEnrollYear() + " year in group " + freshman.getGroup());
    }
}
