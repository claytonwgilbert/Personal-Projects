package com.cg.beerorderservice.web.mappers;

import com.cg.beerorderservice.domain.BeerOrderLine;
import com.cg.beerorderservice.domain.BeerOrderLine.BeerOrderLineBuilder;
import com.cg.brewery.model.BeerOrderLineDto;
import com.cg.brewery.model.BeerOrderLineDto.BeerOrderLineDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-29T14:19:32-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.27.0.v20210823-1758, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class BeerOrderLineMapperImpl_ implements BeerOrderLineMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
        if ( line == null ) {
            return null;
        }

        BeerOrderLineDtoBuilder beerOrderLineDto = BeerOrderLineDto.builder();

        beerOrderLineDto.beerId( line.getBeerId() );
        beerOrderLineDto.createdDate( dateMapper.asOffsetDateTime( line.getCreatedDate() ) );
        beerOrderLineDto.id( line.getId() );
        beerOrderLineDto.lastModifiedDate( dateMapper.asOffsetDateTime( line.getLastModifiedDate() ) );
        beerOrderLineDto.orderQuantity( line.getOrderQuantity() );
        beerOrderLineDto.quantityAllocated( line.getQuantityAllocated() );
        beerOrderLineDto.upc( line.getUpc() );
        if ( line.getVersion() != null ) {
            beerOrderLineDto.version( line.getVersion().intValue() );
        }

        return beerOrderLineDto.build();
    }

    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto) {
        if ( dto == null ) {
            return null;
        }

        BeerOrderLineBuilder beerOrderLine = BeerOrderLine.builder();

        beerOrderLine.beerId( dto.getBeerId() );
        beerOrderLine.createdDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        beerOrderLine.id( dto.getId() );
        beerOrderLine.lastModifiedDate( dateMapper.asTimestamp( dto.getLastModifiedDate() ) );
        beerOrderLine.orderQuantity( dto.getOrderQuantity() );
        beerOrderLine.quantityAllocated( dto.getQuantityAllocated() );
        beerOrderLine.upc( dto.getUpc() );
        if ( dto.getVersion() != null ) {
            beerOrderLine.version( dto.getVersion().longValue() );
        }

        return beerOrderLine.build();
    }
}
