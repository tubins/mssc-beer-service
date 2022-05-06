package com.tubz.msscbeerservice.services;

import com.tubz.msscbeerservice.domain.Beer;
import com.tubz.msscbeerservice.mapper.BeerMapper;
import com.tubz.msscbeerservice.repositories.BeerRepository;
import com.tubz.msscbeerservice.web.controller.NotFoundException;
import com.tubz.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Impl class for @{@link BeerService}.
 */
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(final UUID beerId) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saverNewBeer(final BeerDto beerDto) {
        return beerMapper.beerToBeerDto(
                beerRepository.save(
                        beerMapper.beerDtoToBeer(beerDto)
                )
        );
    }
    @Override
    public BeerDto updateBeer(final UUID beerId, final BeerDto beerDto) {
        Beer beerFound = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beerFound.setBeerName(beerDto.getBeerName());
        beerFound.setBeerStyle(beerDto.getBeerStyle().name());
        beerFound.setPrice(beerDto.getPrice());
        beerFound.setUpc(beerDto.getUpc().toString());
        return beerMapper.beerToBeerDto(beerRepository.save(beerFound));
    }
}
