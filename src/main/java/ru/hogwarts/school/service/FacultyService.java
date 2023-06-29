package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.exceptions.NoSuchMusicEndpointException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class FacultyService {
     private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    // создание объекта
    public FacultyDTO createFaculty(FacultyDTO facultyDTO) {
        facultyRepository.save(facultyDTO.toFaculty());
        return facultyDTO;
    }

    // изменение объекта
    public FacultyDTO updateFaculty(FacultyDTO facultyDTO) {
        facultyRepository.save(facultyDTO.toFaculty());
        return facultyDTO;
    }

    // все факультеты
    public List<FacultyDTO> findAllFaculties() {
        List<Faculty> faculties = facultyRepository.findAll();
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (Faculty faculty : faculties) {
            FacultyDTO facultyDTO = FacultyDTO.fromFaculty(faculty);
            facultyDTOS.add(facultyDTO);
        }
        return facultyDTOS;
    }

    // получить объект по ключу из репозитория
    public FacultyDTO findFacultyById(long id) {
        Faculty faculty = facultyRepository.findFacultyById(id);
        return FacultyDTO.fromFaculty(faculty);
    }

    // получить факультет по цвету
    public List<FacultyDTO> findByColor(String color) {
        List<Faculty> faculties = facultyRepository.findByColor();
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (Faculty faculty : faculties) {
            FacultyDTO facultyDTO = FacultyDTO.fromFaculty(faculty);
            facultyDTOS.add(facultyDTO);
        }
        return facultyDTOS;
    }

    public FacultyDTO findFacultyByNameIgnoreCase(String name) {
        Faculty faculty = facultyRepository.findFacultyByNameIgnoreCase(name);
        return FacultyDTO.fromFaculty(faculty);
    }

    public FacultyDTO findFacultyByStudentId(Long studentId) {
        Faculty faculty = facultyRepository.findFacultyById(studentRepository
                .findById(studentId).get().getFaculty().getId());
        return FacultyDTO.fromFaculty(faculty);
    }

    // удаление из карты
    public void delete(Long id){
        facultyRepository.deleteById(id);
    }

}
