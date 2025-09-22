package guru.springframework.spring6mvc.repositories;

import guru.springframework.spring6mvc.entities.Beer;
import guru.springframework.spring6mvc.entities.BeerOrder;
import guru.springframework.spring6mvc.entities.BeerOrderShipment;
import guru.springframework.spring6mvc.entities.Customer;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerOrderRepositoryTest {

    @Autowired
    BeerOrderRepository beerOrderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerRepository beerRepository;

    Customer testCustomer;
    Beer testBeer;

    @BeforeEach
    void setUp() {
        testCustomer = customerRepository.findAll().get(0);
        testBeer = beerRepository.findAll().get(0);
    }

    @Transactional
    @Test
    void testBeerOrders() {
        new BeerOrder();
        BeerOrder beerOrder = BeerOrder.builder()
                .customerRef("test order")
                .customer(testCustomer)
                .beerOrderShipment(BeerOrderShipment.builder().trackingNumber("1234").build())
                .build();

        BeerOrder savedBeerOrder = beerOrderRepository.save(beerOrder);

        System.out.println(savedBeerOrder.getCustomerRef());
    }

}