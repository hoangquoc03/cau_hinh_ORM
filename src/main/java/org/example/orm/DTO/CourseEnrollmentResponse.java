package org.example.orm.DTO;

import java.time.LocalDateTime;

public class CourseEnrollmentResponse {
    private Long studentId;
    private Long courseId;
    private LocalDateTime enrolledAt;

    public CourseEnrollmentResponse(Long studentId, Long courseId, LocalDateTime enrolledAt) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrolledAt = enrolledAt;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }
}
