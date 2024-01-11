package Spring_Boot_Intro.services.interfaces;

import Spring_Boot_Intro.domain.interfaces.Customer;
import java.util.List;

public interface CustomerService {
  
  Customer save (Customer customer);

  List<Customer> getAllActiveCustomers();

  Customer getActiveCustomersId(int id);

  void update(Customer customer);

  void deleteById(int id);

  void deleteByName(String name);

  void restoreById(int id);

  int getActiveCustomersCount();

  double getTotalCartPriceById(int customerId);

  double getAveragePriceById(int customerId);

  void addProductToCart(int productId, int customerId);

  void deleteProductFromCart(int productId, int customerId);

  void clearCart(int customerId);

}
