package com.example.schoolmanagement.service;
import com.example.schoolmanagement.exceptions.InvalidIdException;
import com.example.schoolmanagement.model.Classes;
import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
    @RequiredArgsConstructor
    public class TeacherService {

        private final TeacherRepository teacherRepository;

        public List<Teacher> getAllTeacher(){
            return teacherRepository.findAll();
        }
        public void addTeacher(Teacher teacher) {
            teacherRepository.save(teacher);
        }
    public Teacher getTeacher(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()){
            return teacherRepository.findById(id).get();
        }else {
            throw new InvalidIdException("Invalid id");
        }
    }
    public List<Classes> getTeacherClasses(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()){
            return teacher.get().getClasses();
        }else {
            throw new InvalidIdException("Invalid id");
        }
    }
    }