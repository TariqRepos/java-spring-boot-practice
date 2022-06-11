package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

// Denotes as a spring bean
@Service
public class StudentService {
    // Service/business layer

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        // Check if students email already exists in database
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        System.out.println(studentOptional);
        System.out.println(student);
        // Ignore post req student if email already exists
        if(studentOptional.isPresent())
            throw new IllegalStateException("email taken");

        // Save student if new student
        studentRepository.save(student);
    }
}
