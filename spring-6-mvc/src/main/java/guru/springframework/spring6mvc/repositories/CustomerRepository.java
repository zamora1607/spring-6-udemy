package guru.springframework.spring6mvc.repositories;

import guru.springframework.spring6mvc.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//implementation is provided in the runtime
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
