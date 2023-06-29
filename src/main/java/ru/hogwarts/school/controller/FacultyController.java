package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;
    @Autowired
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
    public ResponseEntity<List<FacultyDTO>> getAllFaculties() {
        List<FacultyDTO> facultyDTOS = facultyService.findAllFaculties();
        if (facultyDTOS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyDTOS);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findFacultyById(@PathVariable long id){
        Faculty facultyFound = facultyService.findFacultyById(id).toFaculty();
        if (facultyFound == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyFound);
    }

    @GetMapping(params = "color")
    public ResponseEntity<List<FacultyDTO>> findByColor(@RequestParam String color){
        List<FacultyDTO> facultyDTOS = facultyService.findByColor(color);
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
    public ResponseEntity deleteFaculty(@PathVariable long id){
        facultyService.delete(id);
        return ResponseEntity.ok().build();
    }
}
