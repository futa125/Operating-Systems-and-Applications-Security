package hr.fer.lab1.rest;

import hr.fer.lab1.domain.Student;
import hr.fer.lab1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> listStudents(){
        return studentService.listAll();
    }

    @PostMapping("")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }


}
