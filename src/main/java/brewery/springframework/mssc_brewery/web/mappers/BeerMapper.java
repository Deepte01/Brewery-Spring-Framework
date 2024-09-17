package brewery.springframework.mssc_brewery.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import brewery.springframework.mssc_brewery.domain.Beer;
import brewery.springframework.mssc_brewery.web.model.BeerDto;

@Mapper(uses = { DateMapper.class })
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
