package Spring_Boot_Intro.domain;

import Spring_Boot_Intro.domain.interfaces.Cart;
import Spring_Boot_Intro.domain.interfaces.Customer;
import java.util.Objects;

public class CommonCustomer implements Customer {

  private int id;
  private boolean isActive;
  private String name;
  private Cart cart;

  public CommonCustomer() {
    this.isActive = true;
  }

  public CommonCustomer(String name, Cart cart) {
    this.name = name;
    this.cart = cart;
    this.isActive = true;
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
  public String getName() {
    return name;
  }

  @Override
  public Cart getCart() {
    return cart;
  }

  @Override
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
