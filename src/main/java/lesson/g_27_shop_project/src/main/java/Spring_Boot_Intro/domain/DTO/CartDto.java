package Spring_Boot_Intro.domain.DTO;

import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.domain.interfaces.Product;
import java.util.List;

public class CartDto {

  private int id;
  private Customer customer;

  private List<Product> products;

  public CartDto(int id, Customer customer, List<Product> products) {
    this.id = id;
    this.customer = customer;
    this.products = products;
  }

  public int getId() {
    return id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public List<Product> getProducts() {
    return products;
  }
}
