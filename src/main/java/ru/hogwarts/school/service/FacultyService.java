package ru.hogwarts.school.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class FacultyService {
     private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;
    private static final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    // создание объекта
    public FacultyDTO createFaculty(FacultyDTO facultyDTO) {
        logger.info("Create faculty method was invoked");
        facultyRepository.save(facultyDTO.toFaculty());
        return facultyDTO;
    }

    // изменение объекта
    public FacultyDTO updateFaculty(FacultyDTO facultyDTO) {
        logger.info("Update faculty {} method was invoked", facultyDTO);
        facultyRepository.save(facultyDTO.toFaculty());
        return facultyDTO;
    }

    // все факультеты
    public List<FacultyDTO> findAllFaculties() {
        logger.info("Find all faculties method was invoked");
        List<Faculty> faculties = facultyRepository.findAll();
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (Faculty faculty : faculties) {
            FacultyDTO facultyDTO = FacultyDTO.fromFaculty(faculty);
            facultyDTOS.add(facultyDTO);
        }
        return facultyDTOS;
    }

    // получить объект по ключу из репозитория
    public FacultyDTO findFacultyById(Long facultyId) {
        logger.info("Find faculty by id = {} method was invoked", facultyId);
        Faculty faculty = facultyRepository.findFacultyById(facultyId);
        return FacultyDTO.fromFaculty(faculty);
    }

    // получить факультет по цвету
    public List<FacultyDTO> findFacultyByColor(String color) {
        logger.info("Find faculty by color: {} method was invoked", color);
        List<Faculty> faculties = facultyRepository.findFacultyByColor(color);
        List<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (Faculty faculty : faculties) {
            FacultyDTO facultyDTO = FacultyDTO.fromFaculty(faculty);
            facultyDTOS.add(facultyDTO);
        }
        return facultyDTOS;
    }

    public FacultyDTO findFacultyByNameIgnoreCase(String name) {
        logger.info("Find faculty by name: {} ignore case method was invoked", name);
        Faculty faculty = facultyRepository.findFacultyByNameIgnoreCase(name);
        return FacultyDTO.fromFaculty(faculty);
    }

    public FacultyDTO findFacultyByStudentId(Long studentId) {
        logger.info("Find faculty by student id = {} method was invoked", studentId);
        Faculty faculty = facultyRepository.findFacultyById(studentRepository
                .findById(studentId).get().getFaculty().getId());
        return FacultyDTO.fromFaculty(faculty);
    }

    public void deleteFacultId(Long id) throws IllegalStateException {
        logger.info("Delete faculty by id = {} method was invoked", id);
        Faculty faculty = facultyRepository.findFacultyById(id);
        facultyRepository.delete(faculty);
    }

}
