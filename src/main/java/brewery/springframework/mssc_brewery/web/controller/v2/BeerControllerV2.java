package brewery.springframework.mssc_brewery.web.controller.v2;

import brewery.springframework.mssc_brewery.services.BeerService;
import brewery.springframework.mssc_brewery.services.v2.BeerServiceV2;
import brewery.springframework.mssc_brewery.web.model.BeerDto;
import brewery.springframework.mssc_brewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServicev2;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerServicev2 = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return  new ResponseEntity<>(beerServicev2.getBeerById(beerId), HttpStatus.OK);
    }

    // create a new beer
    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDto)
    {
        BeerDto saveDto = beerServicev2.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/api/v1/beer/" + saveDto.getId().toString());
        //send response 201
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDtoV2 beerDto)
    {
        beerServicev2.updateBeer(beerId, beerDto);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId)
    {
        beerServicev2.deleteById(beerId);
    }
}
