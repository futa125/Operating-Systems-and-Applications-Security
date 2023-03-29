package hr.fer.lab1.rest;

import hr.fer.lab1.domain.Record;
import hr.fer.lab1.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("")
    public List<Record> listRecords(){
        return recordService.listAll();
    }

    @PostMapping("")
    public Record createRecord(@RequestBody Record record){
        return recordService.createRecord(record);
    }


}
