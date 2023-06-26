package com.example.itemservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetItemsReturnOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/items/all"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    //TODO: add tests

}
