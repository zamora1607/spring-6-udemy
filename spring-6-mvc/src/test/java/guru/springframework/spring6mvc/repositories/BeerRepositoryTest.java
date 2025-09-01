package guru.springframework.spring6mvc.repositories;

import guru.springframework.spring6mvc.entities.Beer;
import guru.springframework.spring6mvc.model.BeerStyle;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeerBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("My beer 12323fewfefnejfbejhfbkwhjrbfhjfbehjbehfbehjrfbeufbue 12323fewfefnejfbejhfbkwhjrbfhjfbehjbehfbehjrfbeufbue 12323fewfefnejfbejhfbkwhjrbfhjfbehjbehfbehjrfbeufbue")
                    .beerStyle(BeerStyle.IPA)
                    .upc("12345")
                    .price(new BigDecimal("11.99"))
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                .beerName("My beer")
                        .beerStyle(BeerStyle.IPA)
                        .upc("12345")
                        .price(new BigDecimal("11.99"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}