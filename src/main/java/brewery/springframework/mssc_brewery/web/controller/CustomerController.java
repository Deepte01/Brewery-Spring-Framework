package brewery.springframework.mssc_brewery.web.controller;

import brewery.springframework.mssc_brewery.services.BeerService;
import brewery.springframework.mssc_brewery.services.CustomerService;
import brewery.springframework.mssc_brewery.web.model.BeerDto;
import brewery.springframework.mssc_brewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    // create a new beer
    @PostMapping
    public ResponseEntity handlePost(CustomerDto customerDto)
    {
        CustomerDto saveDto = customerService.saveNewBeer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/api/v1/beer/" + saveDto.getId().toString());
        //send response 201
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{custId}"})
    public ResponseEntity handleUpdate(@PathVariable("custId") UUID custId, @RequestBody CustomerDto customerDto)
    {
        customerService.updateCustomer(custId, customerDto);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{custId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("custId") UUID custId)
    {
        customerService.deleteById(custId);
    }
}
