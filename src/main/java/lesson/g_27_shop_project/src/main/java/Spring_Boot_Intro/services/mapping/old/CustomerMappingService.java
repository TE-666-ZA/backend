package Spring_Boot_Intro.services.mapping.old;

import Spring_Boot_Intro.domain.DTO.CartDto;
import Spring_Boot_Intro.domain.DTO.CustomerDto;
import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.domain.jdbc.CommonCustomer;
import Spring_Boot_Intro.domain.jpa.JpaCart;
import Spring_Boot_Intro.domain.jpa.JpaCustomer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMappingService {

  CartMappingService cartMappingService = new CartMappingService();
  public CustomerDto mapEntityToDto (Customer customer){
    CartDto cartDto = cartMappingService.mapEntityToDto(customer.getCart());

    return new CustomerDto(customer.getId(), customer.isActive(), customer.getName(),
        customer.getEmail(), customer.getAge(),cartDto);
  }

  public JpaCustomer mapDtoToJpa (CustomerDto customer){
    JpaCart cart = cartMappingService.mapDtoToJpa(customer.getCart());

    return new JpaCustomer(customer.getId(), customer.isActive(), customer.getName(),
        customer.getEmail(), customer.getAge(),cart);
  }

  public CommonCustomer mapDtoToCommon (CustomerDto customer){
    return new CommonCustomer(customer.getId(), customer.getName());
  }
}
