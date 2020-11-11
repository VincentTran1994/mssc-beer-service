package com.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springframework.msscbeerservice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDto beerDto = new BeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer")
                        .content(beerDtoJson)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception{

        BeerDto updateBeerDto = new BeerDto();
        String beerStoJson = objectMapper.writeValueAsString(updateBeerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                        .accept(MediaType.APPLICATION_JSON)
                        .content(beerStoJson))
                        .andExpect(status().isNoContent());
    }
}