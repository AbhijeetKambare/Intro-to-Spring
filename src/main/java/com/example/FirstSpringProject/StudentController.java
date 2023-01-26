package com.example.FirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/get_student/{adminNo}")
    public ResponseEntity get_student(@PathVariable("adminNo")int adminNo){
        Student student= studentService.getStudent(adminNo);
        if(student==null) return new ResponseEntity<>("Inavlid information",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }
    @GetMapping("/byName")
    public ResponseEntity get_studentbyName(@RequestParam("n") String name){
        Student student=studentService.getStudentByName(name);
        if(student==null) return new ResponseEntity<>("Inavlid Name",HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(student,HttpStatus.FOUND);
    }
    @PostMapping("/add_student")
    public ResponseEntity add_student(@RequestBody Student student){
        String response= studentService.addStudent(student);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("update_student")
    public ResponseEntity update_student(@RequestParam("id") int AdminNo,@RequestParam("no") int rollno){
        String resopnse=studentService.updateStudent(AdminNo,rollno);
        if(resopnse==null) return new ResponseEntity<>("Invalid Information",HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(resopnse,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/Del_Student")
    public ResponseEntity delet_student(@RequestParam("d") int adminNo){
        String resopnse= studentService.deleteStudent(adminNo);
        if(resopnse.equals("Invalid information")){
            return new ResponseEntity<>(resopnse,HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(resopnse,HttpStatus.IM_USED);
    }
}
