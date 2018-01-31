/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francis.app.Dao;

import com.francis.app.Entity.Student;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sly
 */
@Repository
public class StudentDao {
    
    private static Map<Integer, Student> students;
    
    static{
        students = new HashMap<Integer,Student>(){
            
            {
                put(1,new Student(1,"francis","computer science"));
                put(2,new Student(2,"doshi","Programming"));
                put(3,new Student(3,"king","Maths"));
            }
            
        };
    }
    
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }
    
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
          this.students.remove(id);
    }
    
    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(),student);
        
    }

    public void saveStudent(Student student) {
          this.students.put(student.getId(),student);
    }
}
