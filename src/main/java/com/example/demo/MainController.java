package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/mainpage")
    public String main() 
    {
        return "mainpage";
    }

    @GetMapping("/project1")
    public String project1() 
    {
        return "project1";
    }

    @GetMapping("/project2")
    public String project2() 
    {
        return "project2";
    }
}