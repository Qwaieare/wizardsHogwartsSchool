package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO createdStudentDTO = studentService.createStudent(studentDTO);
        return (ResponseEntity<StudentDTO>) ResponseEntity.ok();
    }

    @PutMapping()
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO updateStudentDTO = studentService.updateStudent(studentDTO);
        return ResponseEntity.ok(updateStudentDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> findStudentById(@PathVariable long id){
        StudentDTO studentDTO = studentService.findStudentById(id);
        if (studentDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping
    public ResponseEntity<StudentDTO> findAllStudents(){
        StudentDTO studentFindAll = (StudentDTO) studentService.findAllStudents();
        return ResponseEntity.ok(studentFindAll);
    }

    @GetMapping(params = "age")
    public ResponseEntity<List<StudentDTO>> getStudentsByAge(@RequestParam Integer age){
        List<StudentDTO> studentDTOS = studentService.findStudentByAge(age);
        if (studentDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentDTOS);
    }

    @GetMapping("/findByAgeBetween")
    public ResponseEntity<List<StudentDTO>> getStudentByAgeBetween(@RequestParam int min, @RequestParam int max) {
        List<StudentDTO> studentDTOBetween = studentService.findStudentByAgeBetween(min, max);
        if (studentDTOBetween == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentDTOBetween);
    }

    @GetMapping("/getStudentsByFacultyId")
    ResponseEntity<List<StudentDTO>> getStudentsByFacultyId(@RequestParam Long facultyId) {
        List<StudentDTO> studentDTOByFacultyId = studentService.findStudentByFacultyId(facultyId);
        if (studentDTOByFacultyId == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentDTOByFacultyId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentID(@PathVariable long id) {
        studentService.deleteStudentID(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findNumberOfStudents")
    public ResponseEntity<Long> findNumberOfStudents() {
        Long numberStudents = studentService.findNumberOfStudents();
        if (numberStudents == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(numberStudents);
    }
    @GetMapping("/findMiddleAgeStudents")
    public ResponseEntity<Long> findMiddleAgeStudents() {
        Long middleAge = studentService.findMiddleAgeStudents();
        if (middleAge == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(middleAge);
    }
    @GetMapping("/findFiveYoungStudents")
    ResponseEntity<List<StudentDTO>> findFiveYoungStudents() {
        List<StudentDTO> youngestStudents = studentService.findFiveYoungStudents();
        if (youngestStudents == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(youngestStudents) ;
    }
    @GetMapping("/findSizeAllStudent")
    ResponseEntity<Page<Student>> findSizeAllStudent() {
        return (ResponseEntity<Page<Student>>) studentService.findSizeAllStudent();
    }
}
