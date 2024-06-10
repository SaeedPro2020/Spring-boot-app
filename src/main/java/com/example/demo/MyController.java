package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.utility.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

@RestController
public class MyController {

    @GetMapping("/generate-data")
    public String generateData() {
        try {
            // Generate UUID without dashes and in uppercase
            String uuid = UUIDGenerator.generateUUID();

            // Generate current datetime in "02 January 2018 21:25" format
            String formattedDateTime = DateTimeGenerator.generateCurrentDateTime();

            // Generate two random decimal numbers
            BigDecimal num1 = new BigDecimal("59.3297");
            BigDecimal num2 = new BigDecimal("17.9868");

            // Perform division and round up the result
            BigDecimal divisionResult = DivisionCalculator.calculateDivision(num1, num2);
            BigDecimal roundedResult = ResultRounder.roundResult(divisionResult);

            // Generate calculation result string
            String calculationResult = CalculationResultGenerator.generateCalculationResult(num1, num2, roundedResult);

            // Generate MD5 hash
            String md5Hash = MD5HashGenerator.generateMD5Hash(calculationResult);

            // Create Container object
            Container container = new Container(uuid, formattedDateTime, num1, num2, roundedResult, calculationResult, md5Hash);

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
