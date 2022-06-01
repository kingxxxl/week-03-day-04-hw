package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasessRepository extends JpaRepository<Classes, Integer> {

}
