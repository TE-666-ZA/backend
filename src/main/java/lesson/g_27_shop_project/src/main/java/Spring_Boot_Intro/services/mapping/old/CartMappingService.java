package Spring_Boot_Intro.services.mapping.old;

import Spring_Boot_Intro.domain.DTO.CartDto;
import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.jpa.JpaCart;
import org.springframework.stereotype.Service;

@Service
public class CartMappingService {

  public CartDto mapEntityToDto (Cart cart){
    return new CartDto(cart.getId(),cart.getCustomer(),cart.getProducts());
  }

  public JpaCart mapDtoToJpa (CartDto cart){
    JpaCart entity = new JpaCart();
    entity.setId(cart.getId());
    entity.setCustomer(cart.getCustomer());
    entity.setProducts(cart.getProducts());
    return entity;
  }
}
