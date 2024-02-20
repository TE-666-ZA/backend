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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.Objects;
import java.util.stream.Collectors;

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
  @Pattern(regexp = "[a-z]{4,18}")
  private String name;
  @Column(name = "email")
  @Email
  private String email;

  @Column(name = "age")
  @Min(14)
  @Max(120)
  private int age;

  @OneToOne(mappedBy = "customer")
  @NotNull
  private JpaCart cart;

  public JpaCustomer() {
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public int getAge() {
    return age;
  }

  @Override
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public JpaCustomer(int id, boolean isActive, String name, String email, int age, JpaCart cart) {
    this.id = id;
    this.isActive = isActive;
    this.name = name;
    this.email = email;
    this.age = age;
    this.cart = cart;
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
    return id == that.id && isActive == that.isActive && age == that.age && Objects.equals(
        name, that.name) && Objects.equals(email, that.email) && Objects.equals(
        cart, that.cart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isActive, name, email, age, cart);
  }

  @Override
  public String toString() {
    return "JpaCustomer{" +
        "id=" + id +
        ", isActive=" + isActive +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", age=" + age +
        ", cart=" + cart +
        '}';
  }
}
