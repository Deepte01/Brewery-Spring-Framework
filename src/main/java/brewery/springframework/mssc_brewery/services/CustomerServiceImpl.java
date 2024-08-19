package brewery.springframework.mssc_brewery.services;

import brewery.springframework.mssc_brewery.web.model.BeerDto;
import brewery.springframework.mssc_brewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerByID(UUID custId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .customerName("Galaxy Cat")
                .build();
    }

    @Override
    public CustomerDto saveNewBeer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName(customerDto.getCustomerName())
                .build();
    }

    @Override
    public void updateCustomer(UUID beerId, CustomerDto customerDto) {
       // add implementation later...
    }

    @Override
    public void deleteById(UUID custId) {
        log.debug("Deleting a beer....");
    }
}
