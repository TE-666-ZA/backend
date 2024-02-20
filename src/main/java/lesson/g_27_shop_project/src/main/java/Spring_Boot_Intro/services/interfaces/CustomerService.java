package Spring_Boot_Intro.services.interfaces;

import Spring_Boot_Intro.domain.DTO.CustomerDto;
import Spring_Boot_Intro.domain.interfaces.Customer;
import java.util.List;
import org.springframework.stereotype.Service;


public interface CustomerService {
  
  CustomerDto save (CustomerDto customer);

  List<CustomerDto> getAllActiveCustomers();

  CustomerDto getActiveCustomersById(int id);

  void update(CustomerDto customer);

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
