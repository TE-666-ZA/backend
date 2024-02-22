package Spring_Boot_Intro.services.mapping.mapstruct;

import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.jpa.JpaProduct;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {JpaProductMappingService.class})
public interface JpaListProductMappingService {

List<JpaProduct> mapDtoToJpa (List<ProductDto> products);

List<ProductDto> mapJpaToDto (List<JpaProduct> products);

}
