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

  public CustomerDto() {
  }

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public CartDto getCart() {
    return cart;
  }

  public void setCart(CartDto cart) {
    this.cart = cart;
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
    return "CustomerDto{" +
        "id=" + id +
        ", isActive=" + isActive +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", age=" + age +
        ", cart=" + cart +
        '}';
  }
}
