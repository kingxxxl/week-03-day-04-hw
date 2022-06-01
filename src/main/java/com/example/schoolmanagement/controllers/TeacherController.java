package com.example.schoolmanagement.controllers;
import com.example.schoolmanagement.DTO.API;
import com.example.schoolmanagement.model.Classes;
import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAllTeacher());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeacher(id));

    }
    @GetMapping("/classes/{id}")
    public ResponseEntity<List<Classes>> getTeacherClasses(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeacherClasses(id));

    }

    @PostMapping
    public ResponseEntity<API> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New teacher was added!", 201));
    }
}
