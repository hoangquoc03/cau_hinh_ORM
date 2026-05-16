package org.example.orm.controller;


import org.example.orm.DTO.CourseEnrollmentRequest;
import org.example.orm.DTO.CourseEnrollmentResponse;
import org.example.orm.model.StudentEnrollment;
import org.example.orm.service.StudentEnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.orm.response.ApiResponse;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseEnrollmentController {
    private final StudentEnrollmentService service;

    public CourseEnrollmentController(StudentEnrollmentService service) {
        this.service = service;
    }

    @PostMapping("/{courseId}/enrollments")
    public ResponseEntity<ApiResponse<CourseEnrollmentResponse>> enroll(
            @PathVariable Long courseId,
            @RequestBody CourseEnrollmentRequest req
    ) {
        return ResponseEntity.ok(
                new ApiResponse<>("Enrolled successfully",
                        service.enroll(courseId, req.getStudentId()))
        );
    }


    @DeleteMapping("/{courseId}/enrollments/students/{studentId}")
    public ResponseEntity<ApiResponse<Void>> drop(
            @PathVariable Long courseId,
            @PathVariable Long studentId
    ) {
        service.dropStudent(courseId, studentId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ApiResponse<>("Deleted", null));
    }

    @GetMapping("/{courseId}/enrollments/students")
    public ResponseEntity<ApiResponse<List<StudentEnrollment>>> search(
            @PathVariable Long courseId,
            @RequestParam(required = false) String search
    ) {
        return ResponseEntity.ok(
                new ApiResponse<>("Success", service.search(courseId, search))
        );
    }
}
