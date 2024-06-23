//*        Functionality    */
/*
 *  Test non-empty data generated from first part
 * 
 */

package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DataGenerator.class)
public class DataGeneratorTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void contextLoads() {
        assertThat(objectMapper).isNotNull();
    }

    @Test
    public void testGenerateData() throws Exception {
        MvcResult result = mockMvc.perform(get("/generate-data"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        // Assert that the response is not empty
        assertThat(jsonResponse).isNotEmpty();
    }
}


