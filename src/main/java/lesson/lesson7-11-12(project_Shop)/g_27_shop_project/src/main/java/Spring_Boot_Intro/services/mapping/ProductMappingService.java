package Spring_Boot_Intro.services.mapping;

import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.domain.jdbc.CommonProduct;
import Spring_Boot_Intro.domain.jpa.JpaProduct;
import org.springframework.stereotype.Service;

@Service
public class ProductMappingService {

  public ProductDto mapEntityToDto(Product product){
    return new ProductDto(product.getId(), product.getName(), product.getPrice());
  }

  public JpaProduct mapDtoToJpa (ProductDto product){
    return new JpaProduct(product.getId(),  product.getName(), product.getPrice());
  }

  public CommonProduct mapDtoToCommon (ProductDto product){
    return new CommonProduct(product.getId(),  product.getName(), product.getPrice());
  }

}
