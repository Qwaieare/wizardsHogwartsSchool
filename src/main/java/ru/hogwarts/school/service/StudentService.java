package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.NoSuchMusicEndpointException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
//    private Map<Long, Student> students = new HashMap<>();
//    private Long nextId = 0l;

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // создание объекта: вызываем метод save в репозитории и передаём туда объект
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    // получить объект по ключу из репозитория
    public Student get(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchMusicEndpointException("student"));
    }

    // получить набор всех значений
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // получить студентов по возрасту
    public Collection<Student> getStudentsByAge(int age) {
        return studentRepository.findByAge(age);
    }

    // изменение объекта
    // Если мы хотим отредактировать существующую запись,
    // то мы берём её из репозитория, записываем в неё все обновлённые данные
    // и сохраняем обратно в репозитирий.
    public Student edit(Long id, Student student) {
        return studentRepository.findById(id)
                .map(students -> {
                    student.setName();
                    student.setAge();
                    return studentRepository.save(student);
                })
                .orElseThrow( () -> new NoSuchMusicEndpointException("Can't update student: no such student"));
    }

    // удаление из карты
    public void delete(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new NoSuchMusicEndpointException("Student"));
        studentRepository.deleteById(id);
    }

}

