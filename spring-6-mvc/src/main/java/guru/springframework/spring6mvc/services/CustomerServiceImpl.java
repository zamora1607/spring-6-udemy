package guru.springframework.spring6mvc.services;

import guru.springframework.spring6mvc.model.CustomerDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        CustomerDTO customer1 = CustomerDTO.builder()
                .customerName("John Doe")
                .createdDate(LocalDateTime.now())
                .id(UUID.randomUUID())
                .version(1)
                .build();

        CustomerDTO customer2 = CustomerDTO.builder()
                .customerName("Mary Smith")
                .version(1)
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .build();

        CustomerDTO customer3 = CustomerDTO.builder()
                .customerName("John Deere")
                .version(1)
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public List<CustomerDTO> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.of(customerMap.get(id));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        CustomerDTO newCustomer = CustomerDTO.builder()
                .createdDate(LocalDateTime.now())
                .id(UUID.randomUUID())
                .lastModifiedDate(LocalDateTime.now())
                .customerName(customer.getCustomerName())
                .version(customer.getVersion())
                .build();

        customerMap.put(newCustomer.getId(), newCustomer);

        return newCustomer;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {
        CustomerDTO exisitingCustomer = customerMap.get(customerId);
        exisitingCustomer.setCustomerName(customer.getCustomerName());
        exisitingCustomer.setVersion(customer.getVersion());
        exisitingCustomer.setLastModifiedDate(LocalDateTime.now());

        customerMap.put(customerId, exisitingCustomer);
    }

    @Override
    public void deleteById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchUpdateCustomerById(UUID customerId, CustomerDTO customer) {
        CustomerDTO exisitingCustomer = customerMap.get(customerId);

        if (StringUtils.hasText(customer.getCustomerName())) {
            exisitingCustomer.setCustomerName(customer.getCustomerName());
        }

        if(customer.getVersion() != null) {
            exisitingCustomer.setVersion(customer.getVersion());
        }
    }
}
