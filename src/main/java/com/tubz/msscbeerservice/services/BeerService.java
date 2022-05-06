package com.tubz.msscbeerservice.services;

import com.tubz.msscbeerservice.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

/**
 * Service to handle beer operations.
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saverNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

}
