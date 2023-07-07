package ru.hogwarts.school.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private int age;
    private FacultyDTO faculty;
    private Long facultyId;

    // создает новый объект StudentDTO на основе объекта Student
    public static StudentDTO fromStudent(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setFaculty(FacultyDTO.fromFaculty(student.getFaculty()));
        dto.setFacultyId(student.getFaculty().getId());
        return dto;
    }
    public Student toStudent() {
        Student student = new Student();
        student.setId(this.getId());
        student.setName(this.getName());
        student.setAge(this.getAge());
        student.setFaculty(this.getFaculty().toFaculty());
        return student;
    }
}
