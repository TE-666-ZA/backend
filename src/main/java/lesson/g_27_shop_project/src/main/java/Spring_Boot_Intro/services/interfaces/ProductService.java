package Spring_Boot_Intro.services.interfaces;

import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.interfaces.Product;
import java.util.List;

public interface ProductService {

  ProductDto save (ProductDto product);

  List<ProductDto> getAllActiveProducts();

  ProductDto getActiveProductById(int id);

  void update(ProductDto product);

  void deleteById(int id);

  void deleteByName(String name);

  void restoreById(int id);

  int getActiveProductsCount();

  double getActiveProductsTotalPrice();

  double getActiveProductAveragePrice();


}
