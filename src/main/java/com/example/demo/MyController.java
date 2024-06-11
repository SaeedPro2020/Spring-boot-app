package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.utility.*;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class MyController {

    @GetMapping("/generate-data")
    public String generateData() {
        try {
            // Generate data using the utility method
            Container container = DataGeneratorUtils.generateData();

            // Convert Container object to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(container);

            // Write JSON string to file
            JsonFileWriter.writeToJsonFile(container, "output.json");

            return jsonString;
        } catch (Exception e) {
            return "Error generating data: " + e.getMessage();
        }
    }
}
