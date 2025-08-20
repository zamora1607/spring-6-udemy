package guru.springframework.spring6mvc.mappers;

import guru.springframework.spring6mvc.entities.Beer;
import guru.springframework.spring6mvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
