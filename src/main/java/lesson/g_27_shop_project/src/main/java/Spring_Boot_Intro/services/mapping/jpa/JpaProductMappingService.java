package Spring_Boot_Intro.services.mapping.jpa;

import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.jpa.JpaProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JpaProductMappingService {

  ProductDto mapJpaToDto (JpaProduct jpaProduct);

  JpaProduct mapDtoToJpa (ProductDto productDto);
}
