package Spring_Boot_Intro.repositories.jpa;

import Spring_Boot_Intro.domain.jpa.JpaCustomer;
import Spring_Boot_Intro.domain.jpa.JpaProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaCustomerRepository extends JpaRepository<JpaCustomer,Integer> {

  @Transactional
  JpaCustomer findByName (String name);

  @Query(value = "SELECT COUNT(*) FROM customers WHERE is_active = 1;",nativeQuery = true)
  int getActiveCustomerCount ();

}
