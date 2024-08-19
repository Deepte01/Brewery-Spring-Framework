package brewery.springframework.mssc_brewery.web.controller;

import brewery.springframework.mssc_brewery.services.BeerService;
import brewery.springframework.mssc_brewery.services.CustomerService;
import brewery.springframework.mssc_brewery.web.model.BeerDto;
import brewery.springframework.mssc_brewery.web.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{custId}"})
    public ResponseEntity<CustomerDto> getBeer(@PathVariable("custId") UUID custId) {
        return  new ResponseEntity<>(customerService.getCustomerByID(custId), HttpStatus.OK);
    }
}
