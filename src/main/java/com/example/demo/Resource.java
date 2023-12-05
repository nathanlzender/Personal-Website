package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource 
{

    @Autowired
    private ResourceService service;

    @PostMapping("/resource") //Endpoint to accept JSON data
    public void create(@RequestBody ResourceModel resource) 
    {
        service.save(resource);

    }
}