package com.StudentManagementSystem.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public String home(){
        return "Home";   // view page html file -> home.html
    }

    //------------------------------------------------------------------------------

    @GetMapping("/students")
    public String getAllStudents(Model model){

        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

//----------------------------------------------------------------------------

    @GetMapping("/students/new")
    public String createNewStudent(Model model){

        Student student = new Student();
        model.addAttribute("student", student);

        return "createNewStudent";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
       // Student student = new Student();
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    //---------------------------------------------------------------------------

    @GetMapping("/students/edit/{id}")
    public String editStudent(Model model, @PathVariable int id){

        model.addAttribute("student", studentService.getStudentById(id));
        return "editStudent";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model){

        // Getting student From DB by ID
        Student existingStd = studentService.getStudentById(id);
        existingStd.setFirstName(student.getFirstName());
        existingStd.setLastName(student.getLastName());
        existingStd.setEmail(student.getEmail());
        // saving updated student
        studentService.updateStudent(existingStd);
        return "redirect:/students";
    }

    //-------------------------------------------------------------------------------------------

    @GetMapping("/students/delete/{id}")
    public String deleteStudentById(Model model, @PathVariable Integer id){
        model.addAttribute("student", studentService.getStudentById(id));
        return "redirect:/students";
    }


}
