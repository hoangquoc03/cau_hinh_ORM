package org.example.orm.DTO;

import org.example.orm.model.CourseStatus;

public class CourseUpdateRequest {
    private String title;
    private CourseStatus status;
    private Long instructorId;

    public CourseUpdateRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
}
