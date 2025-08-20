package guru.springframework.spring6mvc.repositories;

import guru.springframework.spring6mvc.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
