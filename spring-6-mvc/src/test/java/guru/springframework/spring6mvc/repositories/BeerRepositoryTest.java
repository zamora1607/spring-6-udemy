package guru.springframework.spring6mvc.repositories;

import guru.springframework.spring6mvc.bootstrap.BootstrapData;
import guru.springframework.spring6mvc.entities.Beer;
import guru.springframework.spring6mvc.model.BeerStyle;
import guru.springframework.spring6mvc.services.BeerCsvServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;


    @Test
    void testGetBeerListByName() {
        List<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%");

        assertThat(list.size()).isEqualTo(336);
    }

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