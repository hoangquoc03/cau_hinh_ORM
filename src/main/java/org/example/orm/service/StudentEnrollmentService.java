package org.example.orm.service;

import org.example.orm.DTO.CourseEnrollmentResponse;
import org.example.orm.model.Course;
import org.example.orm.model.CourseStatus;
import org.example.orm.model.Student;
import org.example.orm.model.StudentEnrollment;
import org.example.orm.repository.CourseRepository;
import org.example.orm.repository.StudentRepository;
import org.example.orm.repository.StudentenrollmentRepository;

import java.time.LocalDateTime;
import java.util.List;

public class StudentEnrollmentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentenrollmentRepository enrollmentRepository;

    public StudentEnrollmentService(StudentRepository studentRepository,
                                    CourseRepository courseRepository,
                                    StudentenrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public CourseEnrollmentResponse enroll(Long courseId, Long studentId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (course.getStatus() != CourseStatus.ACTIVE) {
            throw new RuntimeException("Course is not ACTIVE");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (enrollmentRepository.existsByCourseIdAndStudentId(courseId, studentId)) {
            throw new RuntimeException("Student already enrolled");
        }

        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollment.setEnrolledAt(LocalDateTime.now());

        enrollmentRepository.save(enrollment);

        return new CourseEnrollmentResponse(
                studentId,
                courseId,
                enrollment.getEnrolledAt()
        );
    }

    public void dropStudent(Long courseId, Long studentId) {

        if (!enrollmentRepository.existsByCourseIdAndStudentId(courseId, studentId)) {
            throw new RuntimeException("Enrollment not found");
        }

        enrollmentRepository.deleteByCourseIdAndStudentId(courseId, studentId);
    }

    public List<StudentEnrollment> search(Long courseId, String search) {
        return enrollmentRepository.searchStudents(courseId, search);
    }
}
