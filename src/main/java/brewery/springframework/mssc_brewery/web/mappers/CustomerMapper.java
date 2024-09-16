package brewery.springframework.mssc_brewery.web.mappers;

import org.mapstruct.Mapper;
import brewery.springframework.mssc_brewery.domain.Customer;
import brewery.springframework.mssc_brewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto dto);
}
