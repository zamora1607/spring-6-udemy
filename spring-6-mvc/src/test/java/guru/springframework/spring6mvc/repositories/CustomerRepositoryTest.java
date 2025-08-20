package guru.springframework.spring6mvc.repositories;

import guru.springframework.spring6mvc.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testSaveCustomer() {
        Customer savvedCustomer = customerRepository.save(Customer.builder().customerName("Customer Name").build());

        assertThat(savvedCustomer).isNotNull();
    }
}