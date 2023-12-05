package com.example.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SaltSensor 
{
    @PostMapping("/salt-sensor")
    @ResponseBody
    public ResponseEntity saltsensor(@RequestBody SensorData input) 
    {

        SensorData instance = new SensorData();

        try
        {
            String filename= "datafile.txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(instance.getDistanceCm());//appends the string to the file
            fw.close();
        }
                catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }

        return ResponseEntity.ok(HttpStatus.OK);

    }
    
}
