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
        for (int i = 0; i < getAllStudent().size(); i++) {
            if (msv == getAllStudent().get(i).getMsv()) {
                return getAllStudent().get(i);
            }
        }
        return null;
    }

    public String deleteStudent(int msv) {
        for (int i = 0; i < getAllStudent().size(); i++) {
            if (msv == getAllStudent().get(i).getMsv()) {
                studentRepository.deleteById(msv);
                return "Removed MSV: " + msv;
            }
        }
        return "Not Exist";
    }

    // add new Student
    public Student addStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    // update Student Detail
    public String updateStudent(Student newStudentDetail) {
        for (int i = 0; i < getAllStudent().size(); i++) {
            if (newStudentDetail.getMsv() == getAllStudent().get(i).getMsv()) {
                studentRepository.save(newStudentDetail);
                return "Updated";
            }
        }
        return "Not Found";
    }
}