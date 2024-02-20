package Spring_Boot_Intro.domain.interfaces;

import Spring_Boot_Intro.domain.jpa.JpaProduct;
import java.util.List;

public interface Cart {

  int getId();


  void setId(int id);

  List<JpaProduct> getProducts();

  void addProduct(Product product);
  Customer getCustomer();
  void setCustomer(Customer customer);

  void deleteProductById(int productId);

  void clear();

  double getTotalPrice();

  double getAveragePrice();

}
