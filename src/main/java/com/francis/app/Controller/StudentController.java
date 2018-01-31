/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francis.app.Controller;

import com.francis.app.Entity.Student;
import com.francis.app.Service.StudentService;
import java.awt.PageAttributes.MediaType;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sly
 */
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(method = RequestMethod.GET)
      public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
      
        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
          public Student getStudentById(@PathVariable("id") int id){
            return this.studentService.getStudentById(id);
        
    }
         @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
            public void deleteStudentById(@PathVariable("id") int id){
              studentService.removeStudentById(id);
    }
         @RequestMapping(method = RequestMethod.PUT,value="/{id}")
            public void updateStudent(@RequestBody Student student, @PathVariable int id){
              studentService.updateStudent(student);
    }
           @RequestMapping(method = RequestMethod.POST)
            public String insertStudent(@RequestBody Student student) {
              // Student student = new Student();
                    try {
                       studentService.saveStudent(student);
                    } catch (Exception e) {

                        return e.getMessage();
                    }
                    return "creation successful: " + String.valueOf(student.getId());
    }
}
