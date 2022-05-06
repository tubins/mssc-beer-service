package com.tubz.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tubz.msscbeerservice.web.model.BeerDto;
import com.tubz.msscbeerservice.web.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Beer controller test.
 */
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {

        mockMvc.perform(post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON).content(getBeerDtoJSON()))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON).content(getBeerDtoJSON()))
                .andExpect(status().isNoContent());
    }

    private String getBeerDtoJSON() throws JsonProcessingException {
        BeerDto beerDto = BeerDto.builder()
                .id(null).beerName("Corona")
                .upc(110L).beerStyle(BeerStyle.IPA)
                .price(new BigDecimal("12.05"))
                .build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        return beerDtoJson;
    }
}