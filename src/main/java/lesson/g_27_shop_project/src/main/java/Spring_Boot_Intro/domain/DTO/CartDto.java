package Spring_Boot_Intro.domain.DTO;

import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.domain.interfaces.Product;
import java.util.List;
import java.util.Objects;

public class CartDto {

  private int id;
  private Customer customer;

  private List<ProductDto> products;

  public CartDto() {
  }

  public CartDto(int id, Customer customer, List<ProductDto> products) {
    this.id = id;
    this.customer = customer;
    this.products = products;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<ProductDto> getProducts() {
    return products;
  }

  public void setProducts(List<ProductDto> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartDto cartDto = (CartDto) o;
    return id == cartDto.id && Objects.equals(customer, cartDto.customer)
        && Objects.equals(products, cartDto.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customer, products);
  }

  @Override
  public String toString() {
    return "CartDto{" +
        "id=" + id +
        ", customer=" + customer +
        ", products=" + products +
        '}';
  }
}
