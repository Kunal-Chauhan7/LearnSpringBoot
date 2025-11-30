package com.kunal.thymeleafdemo.controller;

import com.kunal.thymeleafdemo.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloWorldController {

    @Value("${country}")
    private List<String> countries;

    @Value("${language}")
    private List<String> language;

    @Value("${operatingSystem}")
    private List<String> operatingSystem;

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @PostMapping("/processFormOne")
    public String processTheFormOne(Model themodel, @RequestParam String studentName){
        themodel.addAttribute("studentName" , studentName);
        return "helloworld-details";
    }

    @PostMapping("/processForm")
    public String processTheForm(){
        return "helloworld-details";
    }

    @PostMapping("/processFormTwo")
    public String processTheFormTwo(Model themodel, HttpServletRequest request){

        String name = request.getParameter("studentName");

        name = name.toUpperCase();

        String result = "Hey There! " + name;

        themodel.addAttribute("result" , result);
        return "helloworld-details";
    }

    @GetMapping("/studentForm")
    public String showStudentForm(Model themodel){

        themodel.addAttribute("student", new Student());

        themodel.addAttribute("countries",countries);

        themodel.addAttribute("Language",language);

        themodel.addAttribute("operatingSystem",operatingSystem);

        return "student-form";
    }

    @PostMapping("/processStudent")
    public String showStudent(Model themodel, @ModelAttribute("student") Student student){
        themodel.addAttribute("student",student);
        return "student-details";
    }

}
