package Spring_Boot_Intro.domain.jpa;

import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.interfaces.Customer;
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
import java.util.List;

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

  public JpaCart(int id, JpaCustomer customer, List<JpaProduct> products) {
    this.id = id;
    this.customer = customer;
    this.products = products;
  }

  public JpaCustomer getCustomer() {
    return customer;
  }

  @Override
  public void setCustomer(Customer customer) {

  }

  @Override
  public void deleteProductById(int productId) {

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

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }


  @Override
  public void addProduct(Product product) {
    JpaProduct jpaProduct = new JpaProduct(
        product.getId(), product.getName(), product.getPrice()
    );
    this.products.add(jpaProduct);
  }

  public void setCustomer(JpaCustomer customer) {
    this.customer = customer;
  }

  @Override
  public List<JpaProduct> getProducts() {
    return products;
  }

  public void setProducts(List<JpaProduct> products) {
    this.products = products;
  }
}
