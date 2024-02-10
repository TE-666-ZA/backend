package Spring_Boot_Intro.repositories.jpa;

import Spring_Boot_Intro.domain.jpa.JpaProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaProductRepository extends JpaRepository<JpaProduct,Integer> {
   @Transactional
   JpaProduct findByName (String name);

   @Query(value = "SELECT COUNT(*) FROM products WHERE is_active = 1;",nativeQuery = true)
   int getActiveProductsCount ();

   @Query(value = "SELECT SUM(price) From products WHERE is_active = 1;",nativeQuery = true)
   double getActiveProductsTotalPrice ();

   @Query(value = "SELECT AVG(price) From products WHERE is_active = 1;",nativeQuery = true)
   double getActiveProductAveragePrice();
}
