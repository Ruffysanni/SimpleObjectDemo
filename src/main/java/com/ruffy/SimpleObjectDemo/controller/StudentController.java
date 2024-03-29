package com.ruffy.SimpleObjectDemo.controller;

import com.ruffy.SimpleObjectDemo.model.StudentObject;
import com.ruffy.SimpleObjectDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/v1"))
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentObject>>getAllStudents(){
        return  studentService.getAllStudents();
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<StudentObject> getStudentBy(@PathVariable int id){
        return  studentService.getStudentById(id);
    }
    @PostMapping("/student")
    public ResponseEntity<StudentObject> getStudentBy(@RequestBody StudentObject studentObject){
        return  studentService.postStudent(studentObject);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentObject> updateStudentInfo(@PathVariable int id, @RequestBody StudentObject replaceStudentObject){
        return  studentService.updateStudentInfo(id, replaceStudentObject);
    }

    @DeleteMapping("/student")
    public ResponseEntity<StudentObject> deleteStudent(@PathVariable int id){
        return  studentService.deleteStudent(id);
    }

}
