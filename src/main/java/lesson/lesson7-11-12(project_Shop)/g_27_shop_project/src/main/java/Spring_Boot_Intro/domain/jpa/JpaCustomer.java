package Spring_Boot_Intro.domain.jpa;

import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.interfaces.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class JpaCustomer implements Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "is_active")
  private boolean isActive;
  @Column(name = "name")
  private String name;

  @OneToOne(mappedBy = "customer")
  private JpaCart cart;

  public JpaCustomer() {
  }

  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    JpaCart entity = new JpaCart();
    entity.setId(cart.getId());
    entity.setProducts(cart.getProducts());
    this.cart = entity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JpaCustomer that = (JpaCustomer) o;
    return id == that.id && isActive == that.isActive && Objects.equals(name, that.name)
        && Objects.equals(cart, that.cart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isActive, name, cart);
  }

  @Override
  public String toString() {
    return "JpaCustomer{" +
        "id=" + id +
        ", isActive=" + isActive +
        ", name='" + name + '\'' +
        ", cart=" + cart +
        '}';
  }
}
