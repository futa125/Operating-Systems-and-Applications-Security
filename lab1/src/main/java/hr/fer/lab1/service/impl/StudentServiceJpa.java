package hr.fer.lab1.service.impl;

import hr.fer.lab1.dao.StudentRepository;
import hr.fer.lab1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import hr.fer.lab1.domain.Student;
import org.springframework.util.Assert;

@Service
public class StudentServiceJpa implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public List<Student> listAll(){
        return studentRepo.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        Assert.notNull(student, "Student object must be given.");
        Assert.isNull(student.getId(), "Student ID must be null.");
        return studentRepo.save(student);
    }
}
