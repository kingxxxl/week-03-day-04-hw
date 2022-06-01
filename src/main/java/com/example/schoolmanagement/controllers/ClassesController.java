package com.example.schoolmanagement.controllers;

import com.example.schoolmanagement.DTO.API;
import com.example.schoolmanagement.model.Classes;
import com.example.schoolmanagement.service.ClassesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
public class ClassesController {
    private final ClassesService classesService;

    @GetMapping
    public ResponseEntity<List<Classes>> getAllClasses(){
        return ResponseEntity.status(HttpStatus.OK).body(classesService.getAllClasses());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Classes> getClasses(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(classesService.getClasses(id));

    }

    @PostMapping
    public ResponseEntity<API> addClass(@RequestBody @Valid Classes classes){
        classesService.addClasses(classes);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New class was added!", 201));
    }
}
