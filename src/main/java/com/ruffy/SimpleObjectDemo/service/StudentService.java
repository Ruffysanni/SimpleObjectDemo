package com.ruffy.SimpleObjectDemo.service;

import com.ruffy.SimpleObjectDemo.model.StudentObject;
import com.ruffy.SimpleObjectDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<List<StudentObject>> getAllStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
//        return ResponseEntity.ok(studentRepository.findAll());
    }
    public ResponseEntity<StudentObject> getStudentById(int id){
        try{
            return new ResponseEntity<>(studentRepository.findById(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ResponseEntity<StudentObject> postStudent(StudentObject studentObject){
        return new ResponseEntity<>(studentRepository.save(studentObject), HttpStatus.CREATED) ;
    }

    public ResponseEntity<StudentObject> updateStudentInfo(int id, StudentObject replacementObj){
        StudentObject student = studentRepository.findById(id).get();
        student.setFirstName(replacementObj.getFirstName());
        student.setLastName(replacementObj.getLastName());
        student.setAddress(replacementObj.getAddress());
        student.setCourse(replacementObj.getCourse());
        student.setPhoneNumber(replacementObj.getPhoneNumber());

        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

//    public void deleteStudent(int id){
    public ResponseEntity<StudentObject> deleteStudent(int id){
        StudentObject student = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return new ResponseEntity<>(student, HttpStatus.NO_CONTENT);
    }
}
