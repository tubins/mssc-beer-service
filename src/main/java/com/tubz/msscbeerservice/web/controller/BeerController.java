package com.tubz.msscbeerservice.web.controller;

import com.tubz.msscbeerservice.services.BeerService;
import com.tubz.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Beer controller.
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
@Validated
public class BeerController {

    private final BeerService beerService;

    /**
     * API to get beer by Id.
     *
     * @param beerId beer id to match with.
     * @return details of the beer.
     */
    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable final UUID beerId) {
        return new ResponseEntity(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    /**
     * API to save new beer info.
     *
     * @param beerDto new beer info to save.
     * @return created response.
     */
    @PostMapping
    public ResponseEntity saveNewBeer(@Validated @RequestBody final BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saverNewBeer(beerDto),
                HttpStatus.CREATED);
    }

    /**
     * API to update  beer info.
     *
     * @param beerId  beer id to match with.
     * @param beerDto new beer info to save.
     * @return updated response.
     */
    @PutMapping("{beerId}")
    public ResponseEntity updateBeerById(@PathVariable final UUID beerId, @Validated @RequestBody final BeerDto beerDto) {
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
    }
}
