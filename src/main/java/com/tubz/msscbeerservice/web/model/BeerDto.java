package com.tubz.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Dto class for Beer.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private Integer version;
    private OffsetDateTime createdTime;
    private OffsetDateTime modifiedTime;
    private String beerName;
    private BeerStyle beerStyle;
    private BigDecimal price;
    private Integer quantityOnHand;
}
