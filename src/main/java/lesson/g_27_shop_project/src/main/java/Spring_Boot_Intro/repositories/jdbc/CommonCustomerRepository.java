package Spring_Boot_Intro.repositories.jdbc;

import static Spring_Boot_Intro.repositories.jdbc.DBConncection.getConnection;

import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.domain.jdbc.CommonCart;
import Spring_Boot_Intro.domain.jdbc.CommonCustomer;
import Spring_Boot_Intro.domain.jdbc.CommonProduct;
import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.repositories.interfaces.CustomerRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class CommonCustomerRepository implements CustomerRepository {

  private final String ID = "id";
  private final String PRODUCT_ID = "product_id";
  private final String CART_ID = "ca.id";
  private final String CUSTOMER_ID = "cu.id";
  private final String CUSTOMER_NAME = "cu.name";
  private final String PRODUCT_NAME = "p.name";
  private final String PRICE = "price";
  private final String IS_Active = "is_active";

  @Override
  public Customer save(Customer customer) {
    try (Connection connection = getConnection()) {

      String query = String.format(
          "INSERT INTO `customers` (`name`, `is_active`)" +
              "Values ('%s', '1');", customer.getName());

      connection.createStatement().execute(query);

      query = "select id from customers order by id desc limit 1";

      ResultSet resultSet = connection.createStatement().executeQuery(query);

      resultSet.next();

      customer.setId(resultSet.getInt(ID));

      query = String.format("INSERT INTO `first_shop`.`carts` (`customer_id`) VALUES ('%d');",
          customer.getId());

      connection.createStatement().execute(query);

      query = "select id from carts order by id desc limit 1";

      resultSet = connection.createStatement().executeQuery(query);

      resultSet.next();

      customer.setCart(new CommonCart(resultSet.getInt(ID)));

      return customer;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Customer> getAll() {
    try (Connection connection = getConnection()) {

      String query = "select cu.id, cu.name, ca.id, cp.product_id, p.name, p.price, p.is_active " +
          "from customers as cu " +
          "left join carts as ca on cu.id = ca.customer_id " +
          "left join cart_product as cp on ca.id = cp.cart_id " +
          "left join products as p on cp.product_id = p.id " +
          "where cu.is_active = 1;";

      ResultSet resultSet = connection.createStatement().executeQuery(query);
      Map<Integer, Customer> customers = new HashMap<>();

      while (resultSet.next()) {

        int customerId = resultSet.getInt(CUSTOMER_ID);

        Customer customer;

        if (customers.containsKey(customerId)) {
          customer = customers.get(customerId);
        } else {
          int cartId = resultSet.getInt(CART_ID);
          Cart cart = new CommonCart(cartId);

          String customerName = resultSet.getString(CUSTOMER_NAME);
          customer = new CommonCustomer(customerId,true, customerName, cart);
          customers.put(customerId, customer);
        }

        if (resultSet.getBoolean(IS_Active)) {
          int productId = resultSet.getInt(PRODUCT_ID);
          String productName = resultSet.getString(PRODUCT_NAME);
          double price = resultSet.getDouble(PRICE);
          Product product = new CommonProduct(productId, productName, price);
          customer.getCart().addProduct(product);
        }

      }

      return new ArrayList<>(customers.values());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

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
