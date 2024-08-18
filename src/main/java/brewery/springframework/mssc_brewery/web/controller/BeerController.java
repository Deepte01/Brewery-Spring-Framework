package brewery.springframework.mssc_brewery.web.controller;

import brewery.springframework.mssc_brewery.services.BeerService;
import brewery.springframework.mssc_brewery.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
       return  new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }
}
