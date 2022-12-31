package com.example.firstapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.firstapi.model.Student;
import com.example.firstapi.service.StudentService;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    // get all student infomation | R
    @GetMapping(path = "/student")
    private List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    // get student by msv : id  | R
    @GetMapping("/student/{msv}")
    private Student getStudent(@PathVariable("msv") int msv){
        return studentService.getStudent(msv);
    }
    
    @DeleteMapping("/remove/{msv}")
    private String deleteStudent(@PathVariable int msv){
        return studentService.deleteStudent(msv);
    }
    @PostMapping("/addStudent")
    private String addStudent(@RequestBody Student newStudent){
         studentService.addStudent(newStudent);
         return "Added";
    }
    @PutMapping("/updateStudent")
    private String updateStudent(@RequestBody Student newStudent){
        return studentService.updateStudent(newStudent);
    }
}
