package brewery.springframework.mssc_brewery.services;

import brewery.springframework.mssc_brewery.web.model.BeerDto;
import brewery.springframework.mssc_brewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerByID(UUID custId);

    CustomerDto saveNewBeer(CustomerDto customerDto);

    void updateCustomer(UUID custId, CustomerDto customerDto);

    void deleteById(UUID custId);
}
