package Spring_Boot_Intro.services.jdbc;

import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.repositories.jdbc.CommonCustomerRepository;
import Spring_Boot_Intro.services.interfaces.CustomerService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class CommonCustomerService implements CustomerService {

  private CommonCustomerRepository repository;

  public CommonCustomerService(CommonCustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Customer save(Customer customer) {
    if(customer.getName().isEmpty() || customer.getName().isBlank()){
      throw new IllegalArgumentException("Customer name cant be empty");
    }
    return repository.save(customer);
  }

  @Override
  public List<Customer> getAllActiveCustomers() {
    List<Customer> result = repository.getAll();
    if(result.isEmpty()){
      throw new NoSuchElementException("There is no active products");
    }
    return result;
  }

  @Override
  public Customer getActiveCustomersId(int id) {
    return null;
  }

  @Override
  public void update(Customer Customer) {

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
  public int getActiveCustomersCount() {
    return 0;
  }

  @Override
  public double getTotalCartPriceById(int customerId) {
    return 0;
  }

  @Override
  public double getAveragePriceById(int customerId) {
    return 0;
  }

  @Override
  public void addProductToCart(int productId, int customerId) {

  }

  @Override
  public void deleteProductFromCart(int productId, int customerId) {

  }

  @Override
  public void clearCart(int customerId) {

  }
}
