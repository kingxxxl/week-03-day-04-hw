package com.example.schoolmanagement.controllers;
import com.example.schoolmanagement.DTO.API;
import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudent(id));

    }

    @PostMapping
    public ResponseEntity<API> addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New student was added!", 201));
    }

}
