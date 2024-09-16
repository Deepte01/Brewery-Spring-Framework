package brewery.springframework.mssc_brewery.web.mappers;

import brewery.springframework.mssc_brewery.domain.Beer;
import brewery.springframework.mssc_brewery.domain.Beer.BeerBuilder;
import brewery.springframework.mssc_brewery.web.model.BeerDto;
import brewery.springframework.mssc_brewery.web.model.BeerDto.BeerDtoBuilder;
import brewery.springframework.mssc_brewery.web.model.v2.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-15T22:25:10-0600",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( beer.getBeerStyle().name() );
        }
        beerDto.id( beer.getId() );
        beerDto.upc( beer.getUpc() );

        return beerDto.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.beerName( beerDto.getBeerName() );
        if ( beerDto.getBeerStyle() != null ) {
            beer.beerStyle( Enum.valueOf( BeerStyleEnum.class, beerDto.getBeerStyle() ) );
        }
        beer.id( beerDto.getId() );
        beer.upc( beerDto.getUpc() );

        return beer.build();
    }
}
