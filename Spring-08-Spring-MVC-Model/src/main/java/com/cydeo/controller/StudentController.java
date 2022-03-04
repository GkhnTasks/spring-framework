package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homepage(Model model){

        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");
        String subject="Collections";
        model.addAttribute("subject",subject);

        //create some random student id(0-100) and show it in yoour UI

        int studentId= new Random().nextInt();
        model.addAttribute("id",studentId);

        List<Integer> numbers= new ArrayList<>();
        numbers.add(4);
        numbers.add(6);
        numbers.add(100);
        model.addAttribute("numbers",numbers);
        return "/student/welcome";
    }


}
