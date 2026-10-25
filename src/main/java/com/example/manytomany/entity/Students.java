package com.example.manytomany.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String address;
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(
            name="students_courses",
            joinColumns = @JoinColumn(name="students_id"),
            inverseJoinColumns = @JoinColumn(name="courses_id")
    )
    private List<Courses> courses;
}

