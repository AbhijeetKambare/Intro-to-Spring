package com.example.FirstSpringProject;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@Repository
public class StudentReposetory {
    Map<Integer,Student> db=new HashMap<>() ;
    public Student Get(int AdminNo){
        if(db.containsKey(AdminNo))
            return db.get(AdminNo);
        else return null;
    }
    public Student getByName(@RequestParam("n") String name){
        for(Student s:db.values())
            if(Objects.equals(s.getName(),name))
                return s;

        return null;
    }
    public String Add(Student student){
        if(!db.containsKey(student.getAdmin_id())){
            db.put(student.getAdmin_id(), student);
            return "Student added succesfully";
        }
        else return "Student already present";
    }
    public String Delet(int AdminNo){
        if(!db.containsKey(AdminNo)){
            return "Invalid information";
        }
        else {
            db.remove(AdminNo);
        }
        return "Student removed succesfully";
    }
    public String Update(int id,int rollno){
        if(!db.containsKey(id)){
            return null;
        }else {
            db.get(id).setRoll_no(rollno);
        }
        return "record updated succesfully";
    }
}
