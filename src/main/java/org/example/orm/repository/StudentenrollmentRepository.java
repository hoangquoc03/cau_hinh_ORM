package org.example.orm.repository;

import org.example.orm.model.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentenrollmentRepository extends JpaRepository<StudentEnrollment,Long> {
    boolean existsByCourseIdAndStudentId(Long courseId, Long studentId);

    void deleteByCourseIdAndStudentId(Long courseId, Long studentId);

    @Query("""
        SELECT se FROM StudentEnrollment se
        JOIN se.student s
        WHERE se.course.id = :courseId
        AND (:search IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :search, '%')))
    """)
    List<StudentEnrollment> searchStudents(
            @Param("courseId") Long courseId,
            @Param("search") String search
    );
}
