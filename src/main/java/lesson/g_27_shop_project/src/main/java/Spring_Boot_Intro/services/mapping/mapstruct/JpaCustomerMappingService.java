package Spring_Boot_Intro.services.mapping.mapstruct;

import Spring_Boot_Intro.domain.DTO.CartDto;
import Spring_Boot_Intro.domain.DTO.CustomerDto;
import Spring_Boot_Intro.domain.jpa.JpaCart;
import Spring_Boot_Intro.domain.jpa.JpaCustomer;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {JpaCartMappingService.class,JpaListProductMappingService.class})
public interface JpaCustomerMappingService {

  @Mapping(target = "id",source = "id")
  @Mapping(target = "isActive",source = "isActive")
  @Mapping(target = "name",source = "name")
  @Mapping(target = "email",source = "email")
  @Mapping(target = "age",source = "age")
  @Mapping(target = "cart",source = "cart")
  default CustomerDto mapJpaToDto (JpaCustomer jpaCustomer,@Context CycleAvoidingMappingContext context){
    return context.mappedInstance(jpaCustomer,CustomerDto.class);
  }

  @Mapping(target = "id",source = "id")
  @Mapping(target = "isActive",source = "isActive")
  @Mapping(target = "name",source = "name")
  @Mapping(target = "email",source = "email")
  @Mapping(target = "age",source = "age")
  @Mapping(target = "cart",source = "cart")
  default JpaCustomer mapDtoToJpa (CustomerDto customerDto,@Context CycleAvoidingMappingContext context){
    return context.mappedInstance(customerDto,JpaCustomer.class);
  }
}
