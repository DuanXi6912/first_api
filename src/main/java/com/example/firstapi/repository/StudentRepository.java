package com.example.firstapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.firstapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
