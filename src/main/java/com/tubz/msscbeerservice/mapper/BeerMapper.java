package com.tubz.msscbeerservice.mapper;

import com.tubz.msscbeerservice.domain.Beer;
import com.tubz.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Beer mapper class.
 */
@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
