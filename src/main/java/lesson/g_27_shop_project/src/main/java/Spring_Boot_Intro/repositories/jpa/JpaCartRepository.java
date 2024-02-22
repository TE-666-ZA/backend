package Spring_Boot_Intro.repositories.jpa;

import Spring_Boot_Intro.domain.jpa.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCartRepository extends JpaRepository<JpaProduct,Integer> {

}