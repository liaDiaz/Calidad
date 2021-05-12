package com.example.demo;



import com.example.demo.model.OperacionRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc


public class OperacinIntegrationTests {
    

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Test
    public void testSumaController() throws Exception {
        OperacionRequest or= new OperacionRequest();
        or.setA(3);
        or.setB(5);
        ObjectMapper mapper= new ObjectMapper();
        ObjectWriter ow= mapper.writer().withDefaultPrettyPrinter();
        String jsonBody=ow.writeValueAsString(or);
        mockMvc.perform(post("/v1/operacion/suma").contentType(MediaType.APPLICATION_JSON).content(jsonBody)).andExpect(status().isOk());
    }
    @Test
    public void testFailController() throws Exception {

        mockMvc.perform(post("/v1/operacion/suma").contentType(MediaType.APPLICATION_JSON).content("{\"a\":\"hola\",\"b\":\"hola\"}")).andExpect(status().is4xxClientError());
    }
}
