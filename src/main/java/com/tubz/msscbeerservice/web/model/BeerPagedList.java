package com.tubz.msscbeerservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Pageable BeerDto list class.
 */
public class BeerPagedList extends PageImpl<BeerDto> {

    public BeerPagedList(final List<BeerDto> content, final Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPagedList(final List<BeerDto> content) {
        super(content);
    }
}
