package Spring_Boot_Intro.repositories;

import static Spring_Boot_Intro.repositories.DBConncection.getConnection;

import Spring_Boot_Intro.domain.CommonCart;
import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.repositories.interfaces.CustomerRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Repository;

@Repository
public class CommonCustomerRepository implements CustomerRepository {

  private final String ID = "id";
  private final String NAME = "name";
  @Override
  public Customer save(Customer customer) {
    try(Connection connection = getConnection()){

      String query = String.format(
          "INSERT INTO `customers` (`name`, `is_active`)" +
              "Values ('%s', '1');",customer.getName());

      connection.createStatement().execute(query);

      query = "select id from customers order by id desc limit 1";

      ResultSet resultSet = connection.createStatement().executeQuery(query);

      resultSet.next();

      customer.setId(resultSet.getInt(ID));

      query = String.format ("INSERT INTO `first_shop`.`carts` (`customer_id`) VALUES ('%d');",customer.getId());

      connection.createStatement().execute(query);

      query = "select id from carts order by id desc limit 1";

      resultSet = connection.createStatement().executeQuery(query);

      resultSet.next();

      customer.setCart(new CommonCart(resultSet.getInt(ID)));

      return customer;

    }catch (Exception e){
      throw new RuntimeException(e);
    }
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
