package Spring_Boot_Intro.repositories;

import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.repositories.interfaces.ProductRepository;
import java.util.List;

public class CommonProductRepository implements ProductRepository {

  @Override
  public Product save(Product product) {
    return null;
  }

  @Override
  public List<Product> getAll() {
    return null;
  }

  @Override
  public Product getById(int productId) {
    return null;
  }

  @Override
  public Product update(Product product) {
    return null;
  }

  @Override
  public void deleteById(int productId) {

  }
}
