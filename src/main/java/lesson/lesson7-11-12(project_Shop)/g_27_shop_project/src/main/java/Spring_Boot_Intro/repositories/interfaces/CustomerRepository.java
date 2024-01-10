package Spring_Boot_Intro.repositories.interfaces;

import Spring_Boot_Intro.domain.interfaces.Customer;
import java.util.List;

public interface CustomerRepository {

  Customer save(Customer customer);

  List<Customer> getAll();

  Customer getById(int customerId);

  Customer update(Customer customer);

  void deleteById(int customerId);

}
