package com.cg.common.events;

import com.cg.msscservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -1320869026061019841L;

    private BeerDto beerDto;

}
