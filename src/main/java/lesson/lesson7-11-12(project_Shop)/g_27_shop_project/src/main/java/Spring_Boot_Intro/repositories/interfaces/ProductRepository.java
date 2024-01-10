package Spring_Boot_Intro.repositories.interfaces;

import Spring_Boot_Intro.domain.interfaces.Product;
import java.util.List;

public interface ProductRepository {

  Product save (Product product);

  List<Product> getAll();

  Product getById(int productId);

  Product update(Product product);

  void deleteById(int productId);

}
