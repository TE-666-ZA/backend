package Spring_Boot_Intro.domain.interfaces;

import java.util.List;

public interface Cart {

  int getId();

  List<Product> getProducts();

  void addProduct(Product product);

  void delteProductById(int productId);

  void clear();

  double getTotalPrice();

  double getAveragePrice();

}
