package hr.fer.lab1.service;

import hr.fer.lab1.domain.Student;
import java.util.List;

public interface StudentService {

    /**
     * Lists all students in the system.
     * @return list of student objects in the system
     */
    List<Student> listAll();

    /**
     * Created new student in the system.
     * @param student object to create, with ID set to null
     * @return created student object in the system with ID set
     */
    Student createStudent(Student student);
}
