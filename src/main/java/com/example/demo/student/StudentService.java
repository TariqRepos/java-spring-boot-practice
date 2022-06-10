package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Denotes as a spring bean
@Service
public class StudentService {
    // Service/business layer

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Mary",
                        "maryjane@gmail.com",
                        LocalDate.of(2000, Month.APRIL, 5),
                        21
                )
        );
    }
}
