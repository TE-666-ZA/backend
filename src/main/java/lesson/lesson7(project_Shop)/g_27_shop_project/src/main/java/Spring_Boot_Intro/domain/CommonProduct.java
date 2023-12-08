package Spring_Boot_Intro.domain;

import java.util.Objects;

public class CommonProduct implements Product{

  private int id;
  private boolean isActive;
  private String name;
  private double price;

  public CommonProduct(String name, double price) {
    this.name = name;
    this.price = price;
    this.isActive = true;
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

  public int getId() {
    return id;
  }

  public boolean isActive() {
    return isActive;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getPrice() {
    return price;
  }
}
