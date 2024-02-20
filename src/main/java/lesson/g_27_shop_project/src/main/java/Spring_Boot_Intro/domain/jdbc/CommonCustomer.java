package Spring_Boot_Intro.domain.jdbc;

import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.interfaces.Customer;
import java.util.Objects;

public class CommonCustomer implements Customer {

  private int id;
  private boolean isActive;
  private String name;
  private Cart cart;

  private String email;
  private int age;
  public CommonCustomer() {
    this.isActive = true;
  }

  public CommonCustomer(int id, String name) {
    this.id = id;
    this.isActive = true;
    this.name = name;
  }

  public CommonCustomer(String name, Cart cart) {
    this.name = name;
    this.cart = cart;
    this.isActive = true;
  }

  public CommonCustomer(int id, boolean isActive, String name, Cart cart) {
    this.id = id;
    this.isActive = isActive;
    this.name = name;
    this.cart = cart;
  }

  public CommonCustomer(int id, boolean isActive, String name, Cart cart, String email, int age) {
    this.id = id;
    this.isActive = isActive;
    this.name = name;
    this.cart = cart;
    this.email = email;
    this.age = age;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean isActive() {
    return isActive;
  }

  @Override
  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {

  }

  @Override
  public Cart getCart() {
    return cart;
  }


  public void setCart(Cart cart) {
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
    CommonCustomer that = (CommonCustomer) o;
    return id == that.id && isActive == that.isActive && Objects.equals(name, that.name)
        && Objects.equals(cart, that.cart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isActive, name, cart);
  }

  @Override
  public String toString(){
    return String.format("Customer: ID - %d, name - %s, is active - %s."
    ,id,name,isActive() ? "yes" : "no");
  }
}
