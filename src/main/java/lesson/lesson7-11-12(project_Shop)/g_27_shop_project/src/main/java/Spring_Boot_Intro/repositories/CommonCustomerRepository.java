package Spring_Boot_Intro.repositories;

import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.repositories.interfaces.CustomerRepository;
import java.util.List;

public class CommonCustomerRepository implements CustomerRepository {

  @Override
  public Customer save(Customer customer) {
    return null;
  }

  @Override
  public List<Customer> getAll() {
    return null;
  }

  @Override
  public Customer getById(int customerId) {
    return null;
  }

  @Override
  public Customer update(Customer customer) {
    return null;
  }

  @Override
  public void deleteById(int customerId) {

  }
}
