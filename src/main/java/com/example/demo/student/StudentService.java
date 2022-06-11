package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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
        // Check if students email already exists somewhere in database
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        // Ignore post req student if email already exists
        if(studentOptional.isPresent())
            throw new IllegalStateException("email taken");

        // Save student if new student
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        // Check if id exists within database
        boolean exists = studentRepository.existsById(studentId);
        if(!exists)
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        studentRepository.deleteById(studentId);
    }

    @Transactional // Lets you use getters/setters to update database
    public void updateStudent(Long studentId, String name, String email) {
        // Get the student by id if they exist
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                    "student with id " + studentId + " does not exist"
                )
        );

        // Update name if possible and valid
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
            // Update name
            student.setName(name);

        // Update email if possible and valid
        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            // Check if students email already exists somewhere in database
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

            // Throw exception if email already exists
            if(studentOptional.isPresent())
                throw new IllegalStateException("email taken");

            // Update email
            student.setEmail(email);
        }

    }
}
