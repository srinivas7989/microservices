package guru.springFrameWork.msscbrewery.services;

import guru.springFrameWork.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
