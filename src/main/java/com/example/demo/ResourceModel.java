package com.example.demo;

public class ResourceModel {

    private String command;
    private String id;

    // Constructor (default or with parameters as needed)
    public ResourceModel() {
        // Default constructor
    }

    public ResourceModel(String command, String id) {
        this.command = command;
        this.id = id;
    }

    // Getter and Setter methods for command
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    // Getter and Setter methods for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Override toString() method to provide a meaningful representation
    @Override
    public String toString() {
        return "Resource{" +
                "command='" + command + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
