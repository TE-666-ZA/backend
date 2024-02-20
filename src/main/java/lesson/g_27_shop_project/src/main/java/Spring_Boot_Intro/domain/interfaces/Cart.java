package Spring_Boot_Intro.domain.interfaces;

import java.util.List;

public interface Cart {

  int getId();


  void setId(int id);

  List<Product> getProducts();

  void addProduct(Product product);
  Customer getCustomer();
  void setCustomer(Customer customer);

  void deleteProductById(int productId);

  void clear();

  double getTotalPrice();

  double getAveragePrice();

}
