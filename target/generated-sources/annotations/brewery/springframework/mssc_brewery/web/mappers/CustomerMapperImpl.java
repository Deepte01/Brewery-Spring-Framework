package brewery.springframework.mssc_brewery.web.mappers;

import brewery.springframework.mssc_brewery.domain.Customer;
import brewery.springframework.mssc_brewery.domain.Customer.CustomerBuilder;
import brewery.springframework.mssc_brewery.web.model.CustomerDto;
import brewery.springframework.mssc_brewery.web.model.CustomerDto.CustomerDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-16T22:54:20-0600",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.customerName( customer.getCustomerName() );
        customerDto.id( customer.getId() );

        return customerDto.build();
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerBuilder customer = Customer.builder();

        customer.customerName( dto.getCustomerName() );
        customer.id( dto.getId() );

        return customer.build();
    }
}
