package com.example.FirstSpringProject;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class StudentController {
    Map<Integer,Student> db=new HashMap<>() ;
    @GetMapping("/get_student/{adminNo}")
    public Student get_student(@PathVariable("adminNo")int adminNo){
        return db.get(adminNo);
    }
    @GetMapping("/byName")
    public Student get_studentbyName(@RequestParam("n") String name){
        for(Student s:db.values())
           if(Objects.equals(s.getName(),name))
                 return s;

        return null;
    }
    @PostMapping("/add_student")
    public String add_student(@RequestBody Student student){
        db.put(student.getAdmin_id(),student);
        return "Student added successfully";
    }
    @DeleteMapping("/Del_Student")
    public String delet_student(@RequestParam("d") int adminNo){
        if(!db.containsKey(adminNo)) return "Inavlid id";
            db.remove(adminNo);
        return "Student "+adminNo+" has been deleted";
    }
}
