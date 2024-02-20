package Spring_Boot_Intro.services.mapping.old;

import Spring_Boot_Intro.domain.DTO.CartDto;
import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.domain.jdbc.CommonCart;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CartMappingService {
  ProductMappingService productMappingService;

  public CartMappingService() {
    this.productMappingService = productMappingService;
  }

  public CartDto mapEntityToDto (Cart cart){
    List<ProductDto> productDto = new ArrayList<>();
    productDto = cart.getProducts().stream().filter(Product::isActive).map(
        x -> productMappingService.mapEntityToDto(x)
    ).toList();
    return new CartDto(cart.getId(),cart.getCustomer(),productDto);
  }

 // public JpaCart mapDtoToJpa (CartDto cart){
 //   JpaCart entity = new JpaCart();
 //   List<CommonProduct> product = new ArrayList<>();
 //   product = cart.getProducts().stream().map(
 //       x -> productMappingService.mapDtoToCommon(x)
 //   ).toList();
 //   entity.setId(cart.getId());
 //   entity.setCustomer(cart.getCustomer());
 //   entity.setProducts(product);
 //   return entity;
 // }

  public CommonCart mapDtoToCommonCart (CartDto cart){
    CommonCart entity = new CommonCart();
    entity.setId(cart.getId());
    entity.setCustomer(cart.getCustomer());
    return entity;
  }
}
