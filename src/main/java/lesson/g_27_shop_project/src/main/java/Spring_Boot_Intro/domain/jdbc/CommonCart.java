package Spring_Boot_Intro.domain.jdbc;

import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.interfaces.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

public class CommonCart implements Cart {

  private int id;
    private List<Product> products = new ArrayList<>();

  public CommonCart() {
  }

  public CommonCart(int id) {
    this.id = id;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public List<Product> getProducts() {
    return this.products;
  }

  @Override
  public void addProduct(Product product) {
    this.products.add(product);
  }

  @Override
  public void delteProductById(int productId) {
    this.products.removeIf(x ->x.getId() == productId);
  }

  @Override
  public void clear() {
    this.products.clear();
  }

  @Override
  public double getTotalPrice() {
    return this.products.stream()
        .filter(x -> x.isActive())
        .mapToDouble(x -> x.getPrice())
        .sum();
  }

  @Override
  @JsonIgnore
  public double getAveragePrice() {
    return this.products.stream()
        .filter(x -> x.isActive())
        .mapToDouble(x -> x.getPrice())
        .average()
        .orElse(0);
  }
}
