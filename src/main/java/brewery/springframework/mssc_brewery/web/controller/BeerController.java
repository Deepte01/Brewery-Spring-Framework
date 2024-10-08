package brewery.springframework.mssc_brewery.web.controller;

import brewery.springframework.mssc_brewery.services.BeerService;
import brewery.springframework.mssc_brewery.services.BeerServiceImpl;
import brewery.springframework.mssc_brewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({ "/{beerId}" })
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    // create a new beer
    @PostMapping
    public ResponseEntity<Object> handlePost(BeerDto beerDto) {
        log.debug("adding log info");
        BeerDto saveDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/api/v1/beer/" + saveDto.getId().toString());
        // send response 201
        return new ResponseEntity<Object>(null, headers, HttpStatus.CREATED);
    }

    @PutMapping({ "/{beerId}" })
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({ "/{beerId}" })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteById(beerId);
    }
}
