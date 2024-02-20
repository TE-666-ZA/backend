package Spring_Boot_Intro.domain.jdbc;

import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.domain.jpa.JpaProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

public class CommonCart  {

  private int id;
    private List<CommonProduct> products = new ArrayList<>();

  public CommonCart() {
  }

  public CommonCart(int id) {
    this.id = id;
  }


  public int getId() {
    return this.id;
  }


  public void setId(int id) {

  }


  public List<CommonProduct> getProducts() {
    return this.products;
  }


  public void addProduct(CommonProduct product) {
    this.products.add(product);
  }


  public Customer getCustomer() {
    return null;
  }


  public void setCustomer(Customer customer) {

  }


  public void deleteProductById(int productId) {
    this.products.removeIf(x ->x.getId() == productId);
  }


  public void clear() {
    this.products.clear();
  }


  public double getTotalPrice() {
    return this.products.stream()
        .filter(x -> x.isActive())
        .mapToDouble(x -> x.getPrice())
        .sum();
  }


  public double getAveragePrice() {
    return this.products.stream()
        .filter(x -> x.isActive())
        .mapToDouble(x -> x.getPrice())
        .average()
        .orElse(0);
  }
}
