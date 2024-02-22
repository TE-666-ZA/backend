package Spring_Boot_Intro.services.mapping.mapstruct;

import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.jpa.JpaProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JpaProductMappingService {

  ProductDto mapJpaToDto (JpaProduct Product);

  JpaProduct mapDtoToJpa (ProductDto productDto);
}
