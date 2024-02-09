package Spring_Boot_Intro.domain.jpa;

import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.interfaces.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "carts")
public class JpaCart implements Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @OneToOne
  @JoinColumn(name = "customer_id")
  private JpaCustomer customer;
  @ManyToMany
  @JoinTable(
      name = "cart_product",
      joinColumns = @JoinColumn(name = "cart_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  private List<JpaProduct> products;

  public JpaCart() {
  }

  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public JpaCustomer getCustomer() {
    return customer;
  }

  public void setCustomer(JpaCustomer customer) {
       this.customer = customer;
  }

  @Override
  public List<Product> getProducts() {
    return new ArrayList<>(products);
  }

  @Override
  public void addProduct(Product product) {

  }

  @Override
  public void delteProductById(int productId) {

  }

  @Override
  public void clear() {

  }

  @Override
  public double getTotalPrice() {
    return 0;
  }

  @Override
  public double getAveragePrice() {
    return 0;
  }

  public void setProducts(List<Product> products) {
    this.products = products.stream().map(x -> {
      JpaProduct entity = new JpaProduct();
      entity.setId(x.getId());
      entity.setName(x.getName());
      entity.setPrice(x.getPrice());
      entity.setActive(x.isActive());
      return entity;
    }).toList();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JpaCart jpaCart = (JpaCart) o;
    return id == jpaCart.id && Objects.equals(customer, jpaCart.customer)
        && Objects.equals(products, jpaCart.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customer, products);
  }

  @Override
  public String toString() {
    return "JpaCart{" +
        "id=" + id +
        ", customer=" + customer +
        ", products=" + products +
        '}';
  }
}
