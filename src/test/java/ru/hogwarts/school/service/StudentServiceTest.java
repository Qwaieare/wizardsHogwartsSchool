//package ru.hogwarts.school.service;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ru.hogwarts.school.model.Student;
//import ru.hogwarts.school.repository.StudentRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class StudentServiceTest {
//
//    private StudentService studentService;
//
//    @BeforeEach
//    void setUp() {
//        studentService = new StudentService;
//        studentService.add(new Student(1l, "Vasya", 32));
//    }
//
//    // проверка на равенство по возрасту
//    @Test
//    void choosingStudentByAgeInTheCollection() {
//        HashSet<Student> expected = new HashSet<>();
//        expected.add(new Student(1l, "Vasya", 32));
//
//        Set<Student> actual = new HashSet<>(studentService.getAllStudents());
//        assertEquals(expected, actual);
//    }
//
//    // проверка на равенство по возрасту
//    @Test
//    void shouldReturnByAgeInTheCollection() {
//        HashSet<Student> expected = new HashSet<>();
//        expected.add(new Student(2l, "Petya", 27));
//
//        studentService.add(new Student(2l, "Petya", 27));
//        HashSet<Student> actual = new HashSet<>(studentService.getStudentsByAge(27));
//        assertEquals(expected, actual);
//    }
//
//    // получение
//    @Test
//    void shouldReturnStudentWhenGetCalled() {
//        Student expected = new Student(1l, "Vasya", 32);
//        Student actual = studentService.get(1l);
//        assertEquals(expected, actual);
//    }
//
//    // добавление
//    @Test
//    void shouldReturnStudentWhenAddCalled() {
//        Student expected = new Student(2l, "Petya", 27);
//        Student actual = studentService.add(new Student(2l, "Petya", 27));
//        assertEquals(expected, actual);
//    }
//
//    // изменение
////    @Test
////    void shouldReturnStudentWhenEditCalled() {
////        Student expected = new Student(1l, "Vasya", 32);
////        Student actual = studentService.edit(new Student(1l, "Vasya", 32));
////        assertEquals(expected, actual);
////    }
//
//    // удаление
////    @Test
////    void shouldReturnStudentWhenDeleteCalled() {
////        Student expected = new Student(1l, "Vasya", 32);
////        Student actual = studentService.delete(1l);
////        assertEquals(expected, actual);
////    }
//}
