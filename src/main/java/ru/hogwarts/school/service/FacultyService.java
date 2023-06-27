package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.NoSuchMusicEndpointException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
//    private Map<Long, Faculty> faculties = new HashMap<>();
//    private Long nextId = 0l;
     private final FacultyRepository facultyRepository;
     public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    // создание объекта: вызываем метод save в репозитории и передаём туда объект
    public Faculty add(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    // получить объект по ключу из репозитория
    public Faculty get(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new NoSuchMusicEndpointException("faculty"));
    }

    // получить набор всех значений
    public Collection<Faculty> allFaculties(){
        return facultyRepository.findAll();
    }

    // получить факультет по цвету
    public Collection<Faculty> getFacultiesByColor(String color){
        return facultyRepository.findByColor(color);
    }

    // изменение объекта
    public Faculty edit (Long id, Faculty faculty) {
        return facultyRepository.findById(id)
                .map(faculties -> {
                    faculty.setName();
                    faculty.setColor();
                    return facultyRepository.save(faculty);
                })
                .orElseThrow( () -> new NoSuchMusicEndpointException("Can't update faculty: no such faculty"));
    }

    // удаление из карты
    public void delete(Long id){
        facultyRepository.deleteById(id);
    }

}
