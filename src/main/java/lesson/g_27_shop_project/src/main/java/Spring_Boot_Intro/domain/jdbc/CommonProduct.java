package Spring_Boot_Intro.domain.jdbc;

import Spring_Boot_Intro.domain.interfaces.Product;
import java.util.Objects;


public class CommonProduct implements Product {

  private int id;
  private boolean isActive;
  private String name;
  private double price;

  public CommonProduct() {
    this.isActive = true;
  }

  public CommonProduct(String name, double price) {
    this.name = name;
    this.price = price;
    this.isActive = true;
  }

  public CommonProduct(int id, String name, double price) {
    this.id = id;
    this.isActive = true;
    this.name = name;
    this.price = price;
  }



  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    CommonProduct that = (CommonProduct) object;
    return id == that.id && isActive == that.isActive
        && Double.compare(price, that.price) == 0 && Objects.equals(name,
        that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isActive, name, price);
  }

  @Override
  public String toString(){
    return String.format("Product: ID - %d, name - %s, price - %.2f, is available - %s"
        ,id,name,price,isActive ? "yes" : "no");
  }

  public int getId() {
    return id;
  }

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
      this.name = name;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public void setPrice(double price) {
      this.price = price;
  }

  public void setId(int id) {
    this.id = id;
  }
}
