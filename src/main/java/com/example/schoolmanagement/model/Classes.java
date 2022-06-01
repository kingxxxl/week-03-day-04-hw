package com.example.schoolmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@AllArgsConstructor @RequiredArgsConstructor
@Data
@Entity
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
    @NotBlank
    private String  name;

    @ManyToMany(mappedBy = "classesSet")
    @JsonIgnore
    private Set<Student> students;

    @ManyToOne()
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

}
