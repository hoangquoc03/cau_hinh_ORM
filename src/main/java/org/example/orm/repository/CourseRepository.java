package org.example.orm.repository;

import org.example.orm.model.Course;
import org.example.orm.model.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
    boolean existsByIdAndStatus(Long id, CourseStatus status);
}
