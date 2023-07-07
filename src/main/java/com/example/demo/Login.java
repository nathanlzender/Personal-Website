package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class Login 
{

    @PostMapping("/login")
    @ResponseBody
    public RedirectView login( @RequestParam("username") String enteredUsername, @RequestParam("password") String enteredPassword) 
    {
        // MySQL database credentials
        String url = "jdbc:mysql://localhost:3306/personal_website_database";
        String username = "root";
        String password = "password";

        // Establishing the connection
        try 
        {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the MySQL database!");

            // Perform database operations here...
            
            String query = "SELECT * FROM user_table WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) 
            {
                statement.setString(1, enteredUsername);

                ResultSet resultSet = statement.executeQuery();


                if (resultSet.next()) 
                {
                    String hashedPassword = resultSet.getString("password");

                    if (verifyPassword(enteredPassword, hashedPassword)) 
                    {
                        System.out.println("Username and password are correct!");
                        return new RedirectView("/mainpage");
                    } 
                    
                    else 
                    {
                        System.out.println("Incorrect password!");
                    }
                } 
                
                else 
                {
                    System.out.println("Username does not exist!");
                    
                } 

            }
            

            // Closing the connection
            connection.close();
            System.out.println("Connection closed.");
        } 

        catch (SQLException e) 
        {
            System.out.println("Connection to the MySQL database failed!");
            e.printStackTrace();
        }

        return new RedirectView("/loginpage");

    }

        private boolean verifyPassword(String enteredPassword, String hashedPassword) 
        {
        // Implement the password verification logic using the selected secure hashing algorithm (e.g., BCrypt or PBKDF2)
        if (hashedPassword.startsWith("$2a$") || hashedPassword.startsWith("$2b$"))
        {
            return BCrypt.checkpw(enteredPassword, hashedPassword);
        } 

        return false;

        }
}