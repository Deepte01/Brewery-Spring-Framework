package brewery.springframework.mssc_brewery.services;

import brewery.springframework.mssc_brewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
