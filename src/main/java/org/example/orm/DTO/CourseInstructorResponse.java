package org.example.orm.DTO;

public class CourseInstructorResponse {
    private Long id;
    private String name;

    public CourseInstructorResponse() {
    }

    public CourseInstructorResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
