package guru.springframework.spring6mvc.services;

import guru.springframework.spring6mvc.mappers.CustomerMapper;
import guru.springframework.spring6mvc.model.CustomerDTO;
import guru.springframework.spring6mvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> listCustomers() {
        return List.of();
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.empty();
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {

    }

    @Override
    public void deleteById(UUID customerId) {

    }

    @Override
    public void patchUpdateCustomerById(UUID customerId, CustomerDTO customer) {

    }
}
