package org.example.orm.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name",nullable = false,length =100)
    private String name;

    @Column(name ="email",nullable = false)
    private String email;

    @OneToMany(mappedBy = "student")
    private List<StudentEnrollment> enrollments = new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<StudentEnrollment> getEnrollments() {
        return enrollments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnrollments(List<StudentEnrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
