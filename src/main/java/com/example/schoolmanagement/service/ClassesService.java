package com.example.schoolmanagement.service;
import com.example.schoolmanagement.exceptions.InvalidIdException;
import com.example.schoolmanagement.model.Classes;
import com.example.schoolmanagement.model.Classes;
import com.example.schoolmanagement.repository.ClasessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClassesService {

    private final ClasessRepository classesRepository;

    public List<Classes> getAllClasses(){
        return classesRepository.findAll();
    }
    public void addClasses(Classes classes) {
        classesRepository.save(classes);
    }

    public Classes getClasses(Integer id) {
        Optional<Classes> classes = classesRepository.findById(id);
        if (classes.isPresent()){
            return classesRepository.findById(id).get();
        }else {
            throw new InvalidIdException("Invalid id");
        }
    }
}