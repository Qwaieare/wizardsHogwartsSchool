package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

import static ru.hogwarts.school.dto.StudentDTO.fromStudent;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    // создание объекта
    public StudentDTO createStudent(StudentDTO studentDTO) {
        studentRepository.save(studentDTO.toStudent());
        return studentDTO;
    }

    // изменение объекта
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        studentRepository.save(studentDTO.toStudent());
        return studentDTO;
    }

    // найти объект по ключу из репозитория
    public StudentDTO findStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        return fromStudent(student);
    }

    // получить список всех студентов
    public List<StudentDTO> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = StudentDTO.fromStudent(student);
            studentDTOs.add(studentDTO);
        }
        return studentDTOs;
    }

    // получить студентов по возрасту
    public List<StudentDTO> findStudentByAge(int age) {
        List<Student> studentByAge = studentRepository.findByAge(age);
        List<StudentDTO> studentDTOByAge = new ArrayList<>();
        for (Student student : studentByAge) {
            StudentDTO studentDTO = StudentDTO.fromStudent(student);
            studentDTOByAge.add(studentDTO);
        }
        return studentDTOByAge;
    }

    // получить всех студентов, возраст которых находится в промежутке
    public List<StudentDTO> findStudentByAgeBetween(int min, int max) {
        List<Student> studentBetween = studentRepository.findStudentByAgeBetween(min, max);
        List<StudentDTO> studentDTOBetween = new ArrayList<>();
        for (Student student : studentBetween) {
            StudentDTO studentDTO = StudentDTO.fromStudent(student);
            studentDTOBetween.add(studentDTO);
        }
        return studentDTOBetween;
    }

    // найти студента по факультету
    public List<StudentDTO> findStudentByFacultyId(long facultyId) {
        List<Student> studentByFacultyId = studentRepository.findStudentByFaculty_Id(facultyId);
        List<StudentDTO> studentDTOByFacultyId = new ArrayList<>();
        for (Student student : studentByFacultyId) {
            StudentDTO studentDTO = StudentDTO.fromStudent(student);
            studentDTOByFacultyId.add(studentDTO);
        }
        return studentDTOByFacultyId;
    }


    // удаление из карты
    public void deleteStudentID(long id) throws IllegalStateException {
        studentRepository.findById(id);
        List<StudentDTO> studentDTODelete = new ArrayList<>();
        for (StudentDTO student : studentDTODelete) {
            StudentDTO studentDTO = StudentDTO.fromStudent(student.toStudent());
            studentDTODelete.remove(studentDTO);
        }
    }

    // получить количество всех студентов в школе
    public Long findNumberOfStudents() {
        return studentRepository.findNumberOfStudents();
    }

    // получить средний возраст студентов
    public Long findMiddleAgeStudents() {
        return studentRepository.findMiddleAgeStudents();
    }

    // получить пять самых молодых студентов
    public List<StudentDTO> findFiveYoungStudents() {
        return studentRepository.findFiveYoungStudents();
    }
    public Page<Student> findSizeAllStudent() {
        Pageable pageable = PageRequest.of(0, 50);
        return studentRepository.findAll(pageable);
    }
}

