package org.melashvili.jstl_crud_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentsUtils {

    private List<Student> students = new ArrayList<>();

    private static Long counter = 1L;

    private static StudentsUtils instance;

    private StudentsUtils() {}

    public synchronized static StudentsUtils getInstance() {
        if (instance == null) {
            instance = new StudentsUtils();
        }
        return instance;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        student.setId(counter);
        students.add(student);
        counter++;
    }

    // Method gets student by id
    public Student getStudentById(Long id) {
        Optional<Student> first = students
                .stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findFirst();
        return first.orElse(null);
    }

    public void removeStudent(Long id) {
        Optional<Student> first = students.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findFirst();
        first.ifPresent(student -> students.remove(student));
    }

}
