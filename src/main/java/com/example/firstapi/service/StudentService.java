package com.example.firstapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstapi.model.Student;
import com.example.firstapi.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // get all student
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(students1 -> students.add(students1));
        return students;
    }

    // get student by msv

    public Student getStudent(int msv) {
        return studentRepository.findById(msv).get();
    }

    public void deleteStudent(int msv) {
        studentRepository.deleteById(msv);
    }
    // add new Student
    public Student addStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    // update Student Detail
    public String updateStudent(Student newStudentDetail) {
        for (int i = 0; i <= studentRepository.count(); i++) {
            if (newStudentDetail.getMsv() == studentRepository.getReferenceById(i).getMsv()) {
                studentRepository.save(newStudentDetail);
                return "Updated";
            }
        }
        return "Not Found";
    }
}