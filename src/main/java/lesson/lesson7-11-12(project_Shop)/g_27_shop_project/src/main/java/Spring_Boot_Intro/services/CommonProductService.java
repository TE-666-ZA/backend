package Spring_Boot_Intro.services;

import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.repositories.interfaces.ProductRepository;
import Spring_Boot_Intro.services.interfaces.ProductService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class CommonProductService implements ProductService {

  private ProductRepository repository;

  public CommonProductService(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Product save(Product product) {
    if(product == null){
      throw new IllegalArgumentException("Product cant be null");
    }
    if(product.getName().isBlank() || product.getName().isEmpty()){
      throw new IllegalArgumentException("Product name cant be empty");
    }
    if(product.getPrice() <= 0){
      throw new IllegalArgumentException("Product price should be above 0");
    }
    return repository.save(product);
  }

  @Override
  public List<Product> getAllActiveProducts() {
    List<Product> temp = repository.getAll();
    if(temp.isEmpty()){
      throw new NoSuchElementException("There is no active products");
    }
    return temp;
  }

  @Override
  public Product getActiveProductById(int id) {
    return null;
  }

  @Override
  public void update(Product product) {

  }

  @Override
  public void deleteById(int id) {

  }

  @Override
  public void deleteByName(String name) {

  }

  @Override
  public void restoreById(int id) {

  }

  @Override
  public int getActiveProductsCount() {
    return 0;
  }

  @Override
  public double getActiveProductsTotalPrice() {
    return 0;
  }

  @Override
  public double getActiveProductAveragePrice() {
    return 0;
  }
}
