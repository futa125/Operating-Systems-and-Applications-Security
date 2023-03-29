package hr.fer.lab1.service;

import hr.fer.lab1.domain.Record;

import java.util.List;

public interface RecordService {

    /**
     * Lists all records in the system.
     * @return list of record objects in the system
     */
    List<Record> listAll();

    /**
     * Created new record in the system.
     * @param record object to create, with ID set to null
     * @return created record object in the system with ID set
     */
    Record createRecord(Record record);
}
