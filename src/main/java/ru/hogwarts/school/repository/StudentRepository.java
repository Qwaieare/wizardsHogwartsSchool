package ru.hogwarts.school.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>  {
    @Query(nativeQuery = true)
    List<Student> findByAge(int age);
    List<Student> findStudentByAgeBetween(int min, int max);
    List<Student> findStudentByFaculty_Id(Long facultyId);

    @Query(value = "SELECT count(*) FROM student", nativeQuery = true)
    Long findNumberOfStudents();

    @Query(value = "SELECT * FROM student", nativeQuery = true)
    Long findMiddleAgeStudents();

    @Query(value = "SELECT name, age FROM student ORDER BY age LIMIT 5", nativeQuery = true)
    List<StudentDTO> findFiveYoungStudents();

    @Query(value = "SELECT * FROM student", nativeQuery = true)
    Page<Student> findAll(Pageable pageable);
}

