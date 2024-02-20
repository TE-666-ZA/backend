package Spring_Boot_Intro.domain.DTO;

import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.jpa.JpaCart;
import java.util.Objects;

public class CustomerDto {

  private int id;
  private boolean isActive;
  private String name;
  private String email;
  private int age;
  private CartDto cart;

  public CustomerDto(int id, boolean isActive, String name, String email, int age, CartDto cart) {
    this.id = id;
    this.isActive = isActive;
    this.name = name;
    this.email = email;
    this.age = age;
    this.cart = cart;
  }

  public int getId() {
    return id;
  }

  public boolean isActive() {
    return isActive;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public int getAge() {
    return age;
  }

  public CartDto getCart() {
    return cart;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDto that = (CustomerDto) o;
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
    return "Customer{" +
        "id=" + id +
        ", isActive=" + isActive +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", age=" + age +
        ", cart=" + cart +
        '}';
  }
}
