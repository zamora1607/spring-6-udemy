package guru.springframework.spring6mvc.mappers;

import guru.springframework.spring6mvc.entities.Customer;
import guru.springframework.spring6mvc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
