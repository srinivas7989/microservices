package guru.springFrameWork.msscbrewery.services;

import guru.springFrameWork.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
