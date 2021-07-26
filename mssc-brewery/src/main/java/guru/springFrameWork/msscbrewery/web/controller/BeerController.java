package guru.springFrameWork.msscbrewery.web.controller;

import guru.springFrameWork.msscbrewery.services.BeerService;
import guru.springFrameWork.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
    return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    //post - create new beer
    @PostMapping
    public ResponseEntity handlePost(BeerDto beerDto){
        BeerDto saveDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("location","/api/v1/beer"+ saveDto.getBeerId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }


    //    Put - update beer
    @PutMapping({"/{beerId}"})
    public ResponseEntity handlePut(@PathVariable("beerId") UUID beerId, BeerDto beerDto){
        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
