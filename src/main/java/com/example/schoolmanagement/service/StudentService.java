package com.example.schoolmanagement.service;
import com.example.schoolmanagement.exceptions.InvalidIdException;
import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(Integer id) {
         Optional<Student> student = studentRepository.findById(id);
         if (student.isPresent()){
             return studentRepository.findById(id).get();
         }else {
               throw new InvalidIdException("Invalid student id");
         }
    }
}
