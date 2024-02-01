package Spring_Boot_Intro.repositories.jpa;

import Spring_Boot_Intro.domain.jpa.JpaCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<JpaCustomer,Integer> {

}
