package com.cg.msscservice.events;

import com.cg.msscservice.web.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -1320869026061019841L;

    private final BeerDto beerDto;
}
