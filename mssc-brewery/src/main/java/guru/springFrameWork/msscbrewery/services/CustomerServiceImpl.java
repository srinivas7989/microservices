package guru.springFrameWork.msscbrewery.services;

import guru.springFrameWork.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().customerId(UUID.randomUUID())
                .customerName("srinivas")
                .build();
    }
}
