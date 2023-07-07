//package ru.hogwarts.school.service;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ru.hogwarts.school.model.Faculty;
//import ru.hogwarts.school.repository.FacultyRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class FacultyServiceTest {
//    private FacultyService facultyService;
//
//    @BeforeEach
//    void setUp() {
//        facultyService = new FacultyService;
//        facultyService.add(new Faculty(1l, "Gryffindor", "red"));
//    }
//
//    // проверка на равенство по цвету
//    @Test
//    void choosingFacultyByRedColorInTheCollection() {
//        HashSet<Faculty> expected = new HashSet<>();
//        expected.add(new Faculty(1l, "Gryffindor", "red"));
//
//        Set<Faculty> actual = new HashSet<>(facultyService.allFaculties());
//        assertEquals(expected, actual);
//    }
//
//    // проверка на равенство по цвету
//    @Test
//    void choosingFacultyByGreenColorInTheCollection() {
//        HashSet<Faculty> expected = new HashSet<>();
//        expected.add(new Faculty(2l, "Slytherin", "green"));
//
//        facultyService.add(new Faculty(2l, "Slytherin", "green"));
//        HashSet<Faculty> actual = new HashSet<>(facultyService.getFacultiesByColor("green"));
//        assertEquals(expected, actual);
//    }
//
//    // получение
//    @Test
//    void shouldReturnFacultyWhenGetCalled() {
//        Faculty expected = new Faculty(1l, "Gryffindor", "red");
//        Faculty actual = facultyService.get(1l);
//        assertEquals(expected, actual);
//    }
//
//    // добавление
//    @Test
//    void shouldReturnFacultyWhenAddCalled() {
//        Faculty expected = new Faculty(2l, "Slytherin", "green");
//        Faculty actual = facultyService.add(new Faculty(2l, "Slytherin", "green"));
//        assertEquals(expected, actual);
//    }
//
//    // изменение
////    @Test
////    void shouldReturnFacultyWhenEditCalled() {
////        Faculty expected = new Faculty(1l, "Griffindor", "red");
////        Faculty actual = facultyService.edit(new Faculty(1l, "Griffindor", "red"));
////        assertEquals(expected, actual);
////    }
////
////    // удаление
////    @Test
////    void shouldReturnFacultyWhenDeleteCalled() {
////        Faculty expected = new Faculty(1l, "Gryffindor", "red");
////        Faculty actual = facultyService.delete(1l);
////        assertEquals(expected, actual);
////    }
//}
