package org.example.orm.repository;

import org.example.orm.model.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentenrollmentRepository extends JpaRepository<StudentEnrollment,Long> {
}
