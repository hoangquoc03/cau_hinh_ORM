package org.example.orm.DTO;

import org.example.orm.model.CourseStatus;

public class CourseResponse {
    private Long id;
    private String title;
    private CourseStatus status;
    private CourseInstructorResponse instructor;

    public CourseResponse() {
    }

    public CourseResponse(Long id,
                          String title,
                          CourseStatus status,
                          CourseInstructorResponse instructor) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public CourseInstructorResponse getInstructor() {
        return instructor;
    }
}
