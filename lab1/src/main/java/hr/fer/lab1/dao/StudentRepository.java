package hr.fer.lab1.dao;

import hr.fer.lab1.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
