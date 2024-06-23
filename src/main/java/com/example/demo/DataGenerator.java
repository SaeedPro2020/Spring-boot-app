//*        Functionality    */
/*
 *  Calls the first part as library and generate data for endpoint.
 */

package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.utility.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.errorhandling.*;

@RestController
public class DataGenerator {

    @GetMapping("/generate-data")
    public String generateData() {
        try {
            // Generate data using the utility method
            Container container = DataGeneratorUtils.generateData();

            // Convert Container object to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(container);

            return jsonString;
        } catch (RuntimeException e) {
            throw new DataGenerationException("Error generating data: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new JsonProcessingException("Error processing JSON: " + e.getMessage(), e);
        }
    }
}
