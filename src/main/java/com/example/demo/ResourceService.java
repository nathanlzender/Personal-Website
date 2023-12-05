package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    // Simulating an in-memory storage for Resource objects
    private List<ResourceModel> resourceList = new ArrayList<>();

    public void save(ResourceModel resource) {
        // Assuming this method saves the resource to a database or any storage
        // For this example, it just adds the resource to the list
        resourceList.add(resource);
        System.out.println("Resource saved: " + resource.toString());

        for (ResourceModel outputResource : resourceList)
        {
            System.out.println(outputResource);

        }
        
    }

    public List<ResourceModel> getAllResources() {
        // Return all resources stored (for demonstration purposes)
        return resourceList;
    }

}
