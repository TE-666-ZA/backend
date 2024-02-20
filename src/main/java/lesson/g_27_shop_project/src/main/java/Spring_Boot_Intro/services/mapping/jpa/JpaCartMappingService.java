package Spring_Boot_Intro.services.mapping.jpa;

import Spring_Boot_Intro.domain.DTO.CartDto;
import Spring_Boot_Intro.domain.jpa.JpaCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JpaCartMappingService {

  CartDto mapJpaToDto (JpaCart jpaCart);

  JpaCart mapDtoToJpa (CartDto cartDto);
}
