package Spring_Boot_Intro.services.mapping.jpa;

import Spring_Boot_Intro.domain.DTO.CustomerDto;
import Spring_Boot_Intro.domain.jpa.JpaCustomer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JpaCustomerMappingService {

  CustomerDto mapJpaToDto (JpaCustomer jpaCustomer);

  JpaCustomer mapDtoToJpa (CustomerDto customerDto);
}
