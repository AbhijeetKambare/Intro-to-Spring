package com.example.FirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentReposetory studentReposetory;
    public Student getStudent(int id){
        return studentReposetory.Get(id);
    }
    public Student getStudentByName(String name){
        return studentReposetory.getByName(name);
    }
    public String addStudent(Student student){
        return studentReposetory.Add(student);
    }
    public String updateStudent(int id,int no){
        return studentReposetory.Update(id,no);
    }
    public String deleteStudent(int id){
        return studentReposetory.Delet(id);
    }
}
