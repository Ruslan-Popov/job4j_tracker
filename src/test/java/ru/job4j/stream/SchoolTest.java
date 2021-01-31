package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(10, "Surname 1"));
        students.add(new Student(20, "Surname 2"));
        students.add(new Student(30, "Surname 3"));
        students.add(new Student(40, "Surname 4"));
        students.add(new Student(50, "Surname 5"));
        students.add(new Student(60, "Surname 6"));
        students.add(new Student(70, "Surname 7"));
        students.add(new Student(80, "Surname 8"));
        students.add(new Student(90, "Surname 9"));
    }

    @Test
    public void whenCollectClassA() {
        School sc = new School();
        Predicate<Student> pr = stud -> stud.getScore() >= 70 && stud.getScore() <= 100;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname 7"));
        expected.add(new Student(80, "Surname 8"));
        expected.add(new Student(90, "Surname 9"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        School sc = new School();
        Predicate<Student> pr = stud -> stud.getScore() >= 50 && stud.getScore() <= 69;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname 5"));
        expected.add(new Student(60, "Surname 6"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        School sc = new School();
        Predicate<Student> pr = stud -> stud.getScore() >= 0 && stud.getScore() <= 49;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname 1"));
        expected.add(new Student(20, "Surname 2"));
        expected.add(new Student(30, "Surname 3"));
        expected.add(new Student(40, "Surname 4"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenStudentsToMap() {
        School sc = new School();
        Map<String, Student> rst = sc.studMap(students);
        assertThat(rst.get("Surname 2"), is (new Student(20, "Surname 2")));
    }
}