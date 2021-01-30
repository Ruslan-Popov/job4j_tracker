package ru.job4j.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public HashMap<String, Student> studMapOldway(List<Student> students) {
        HashMap<String, Student> mapSt = new HashMap<>();
        for (Student stu : students) {
            mapSt.put(stu.getSurname(), stu);
        }
        return mapSt;
    }

    public Map<String, Student> studMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(
                        Collectors.toMap(
                                s -> s.getSurname(),
                                s -> s
                        )
                );
    }
}
