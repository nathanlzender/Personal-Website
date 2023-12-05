package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainController {

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

    @GetMapping("/loginpage")
    public String loginpage() 
    {
        return "loginpage";
    }

    @GetMapping("/aboutme")
    public String aboutme() 
    {
        return "aboutme";
    }

    @GetMapping("/survive")
    public String survive() 
    {
        return "survive";
    }

    @GetMapping("/salt-sensor")
    public String saltsensor() 
    {
        return "salt-sensor";
    }

}