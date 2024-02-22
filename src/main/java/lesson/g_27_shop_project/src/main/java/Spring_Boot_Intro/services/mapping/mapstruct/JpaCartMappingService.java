package Spring_Boot_Intro.services.mapping.mapstruct;

import Spring_Boot_Intro.domain.DTO.CartDto;
import Spring_Boot_Intro.domain.jpa.JpaCart;
import Spring_Boot_Intro.services.mapping.old.CustomerMappingService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {JpaListProductMappingService.class,
    CustomerMappingService.class})
public interface JpaCartMappingService {

 @Mapping(target = "id", source = "id")
 @Mapping(target = "customer",source = "customer")
 @Mapping(target = "products",source = "products")
 default CartDto mapJpaToDto (JpaCart jpaCart,@Context CycleAvoidingMappingContext context){
  return context.mappedInstance(jpaCart,CartDto.class);
 }
 @Mapping(target = "id", source = "id")
 @Mapping(target = "customer",source = "customer")
 @Mapping(target = "products",source = "products")
 default JpaCart mapDtoToJpa (CartDto cartDto,@Context CycleAvoidingMappingContext context){
  return context.mappedInstance(cartDto,JpaCart.class);
 }
}
