package com.tubz.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tubz.msscbeerservice.bootstrap.BeerLoader;
import com.tubz.msscbeerservice.services.BeerService;
import com.tubz.msscbeerservice.web.model.BeerDto;
import com.tubz.msscbeerservice.web.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
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

    @MockBean
    private BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        when(beerService.getBeerById(any())).thenReturn(getBeerDto());
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        String beerDtoJson = objectMapper.writeValueAsString(getBeerDto());
        when(beerService.saverNewBeer(any())).thenReturn(getBeerDto());
        mockMvc.perform(post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        when(beerService.updateBeer(any(), any())).thenReturn(getBeerDto());
        String beerDtoJson = objectMapper.writeValueAsString(getBeerDto());
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

    private BeerDto getBeerDto() throws JsonProcessingException {
        return BeerDto.builder()
                .id(null).beerName("Corona")
                .upc(BeerLoader.BEER_1_UPC).beerStyle(BeerStyle.IPA)
                .price(new BigDecimal("12.05"))
                .build();
    }
}