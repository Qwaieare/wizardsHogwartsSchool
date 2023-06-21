package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable long id){
        return studentService.get(id);
    }

    @GetMapping(params = "age")
    public Collection<Student> getStudentsByAge(@RequestParam Integer age){
        return studentService.getStudentsByAge(age);
    }

    @PostMapping
    public Student add(@RequestBody Student student){
        return studentService.add(student);
    }

    @PutMapping()
    public Student edit(@RequestBody Student student) {
        return studentService.edit(student);
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable long id){
        return studentService.delete(id);
    }

}