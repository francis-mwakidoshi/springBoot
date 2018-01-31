/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francis.app.Service;

import com.francis.app.Dao.StudentDao;
import com.francis.app.Entity.Student;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sly
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    
     public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }
     
      public Student getStudentById(int id){
        return this.studentDao.getStudentById(id);
        
    }

    public void removeStudentById(int id) {
       this.studentDao.removeStudentById(id);
    }
    
     public void updateStudent(Student student){
      
          this.studentDao.updateStudent(student);
        
    }

    public void saveStudent(Student student) {
           this.studentDao.saveStudent(student);
    }
    
}
