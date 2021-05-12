package com.example.demo;

import com.example.demo.service.OperacionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperacionUnitTests {
    


    @Autowired
    OperacionService operacionService;

    @Test
    public void testSuma(){
        assertEquals(5.0,operacionService.suma(2,3));
    }
}
