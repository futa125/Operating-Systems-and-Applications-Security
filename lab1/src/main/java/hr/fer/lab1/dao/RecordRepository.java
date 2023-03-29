package hr.fer.lab1.dao;

import hr.fer.lab1.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordRepository extends JpaRepository<Record, Long> {
}
