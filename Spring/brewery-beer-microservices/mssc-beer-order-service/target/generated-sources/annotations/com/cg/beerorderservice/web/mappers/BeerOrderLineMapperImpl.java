package com.cg.beerorderservice.web.mappers;

import com.cg.beerorderservice.domain.BeerOrderLine;
import com.cg.brewery.model.BeerOrderLineDto;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-29T14:19:32-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.27.0.v20210823-1758, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
@Primary
public class BeerOrderLineMapperImpl extends BeerOrderLineMapperDecorator implements BeerOrderLineMapper {

    @Autowired
    @Qualifier("delegate")
    private BeerOrderLineMapper delegate;

    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto)  {
        return delegate.dtoToBeerOrderLine( dto );
    }
}
