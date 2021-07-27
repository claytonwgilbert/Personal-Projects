package com.cg.msscbrewery.services;

import com.cg.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}

