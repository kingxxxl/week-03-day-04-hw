package com.example.schoolmanagement.model;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Set;

@AllArgsConstructor @RequiredArgsConstructor @Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
    @NotBlank
    private String  name;
    @NotNull
    private Integer  age;
    @NotBlank
    private String  major;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Classes> classesSet;
}
