package com.tubz.msscbeerservice.repositories;

import com.tubz.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * Beer JPA repository.
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
