package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;
     public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping()
    public ResponseEntity<FacultyDTO> createFaculty(@RequestBody FacultyDTO facultyDTO) {
        FacultyDTO createdFacultyDTO = facultyService.createFaculty(facultyDTO);
        return ResponseEntity.ok(createdFacultyDTO);
    }


    @PutMapping()
    public ResponseEntity<FacultyDTO> updateFaculty(@RequestBody FacultyDTO facultyDTO) {
        FacultyDTO updateFacultyDTO = facultyService.updateFaculty(facultyDTO);
        return ResponseEntity.ok(updateFacultyDTO);
    }

    @GetMapping
    public ResponseEntity<List<FacultyDTO>> findAllFaculties() {
        List<FacultyDTO> facultyDTOS = facultyService.findAllFaculties();
        if (facultyDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyDTOS);
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<Object> findFacultyById(@PathVariable Long facultyId){
        Faculty facultyFound = facultyService.findFacultyById(facultyId).toFaculty();
        if (facultyFound == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyFound);
    }

    @GetMapping("/findByColor")
    public ResponseEntity<List<FacultyDTO>> findFacultyByColor(@RequestParam String color){
        List<FacultyDTO> facultyDTOS = facultyService.findFacultyByColor(color);
        if (facultyDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyDTOS);
    }

    @GetMapping("/findFacultyByName")
    public ResponseEntity<FacultyDTO> getFacultyByName(@RequestParam String name) {
        FacultyDTO facultyDTO = facultyService.findFacultyByNameIgnoreCase(name);
        if (facultyDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyDTO);
    }

    @GetMapping("/findByStudentId")
    public ResponseEntity<FacultyDTO> getFacultyByStudentId(@RequestParam Long studentId) {
        FacultyDTO facultyDTO = facultyService.findFacultyByStudentId(studentId);
        if (facultyDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacultId(@PathVariable Long id){
        facultyService.deleteFacultId(id);
        return ResponseEntity.ok().build();
    }
}
