package Spring_Boot_Intro.repositories.jdbc;

import static Spring_Boot_Intro.repositories.jdbc.DBConncection.getConnection;

import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.domain.jdbc.CommonProduct;
import Spring_Boot_Intro.repositories.interfaces.ProductRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Repository;

@Repository
public class CommonProductRepository implements ProductRepository {

  private final String ID = "id";
  private final String NAME = "name";
  private final String PRICE = "price";

  @Override
  public Product save(Product product) {
     try(Connection connection = getConnection()) {

    String query = String.format(Locale.US,"INSERT INTO `products` (`name`, `price`, `is_active`)" +
        "Values ('%s', '%.2f', '1');",product.getName(),product.getPrice());

    connection.createStatement().execute(query);

    query = "select id from products order by id desc limit 1";
    ResultSet resultSet = connection.createStatement().executeQuery(query);
    resultSet.next();
    int id = resultSet.getInt(ID);
    product.setId(id);
    return product;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Product> getAll() {
    try(Connection connection = getConnection()) {

      String query ="SELECT id,name,price FROM first_shop.products where is_Active = 1;";

      ResultSet resultSet = connection.createStatement().executeQuery(query);

      List<Product> products = new ArrayList<>();
      while (resultSet.next()){
        products.add(new CommonProduct(resultSet.getInt(ID),
            resultSet.getString(NAME),resultSet.getDouble(PRICE)));
      }
        return products;
    }catch (Exception e){
      throw new RuntimeException(e);
    }
  }

  @Override
  public Product getById(int productId) {
    return null;
  }

  @Override
  public Product update(Product product) {
    return null;
  }

  @Override
  public void deleteById(int productId) {

  }
}
