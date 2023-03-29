package hr.fer.lab1.service.impl;

import hr.fer.lab1.dao.RecordRepository;
import hr.fer.lab1.domain.Record;
import hr.fer.lab1.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class RecordServiceJpa implements RecordService {

    @Autowired
    private RecordRepository recordRepo;

    @Override
    public List<Record> listAll(){
        return recordRepo.findAll();
    }

    @Override
    public Record createRecord(Record record) {
        Assert.notNull(record, "Record object must be given.");
        Assert.isNull(record.getId(), "Record ID must be null.");
        return recordRepo.save(record);
    }
}
