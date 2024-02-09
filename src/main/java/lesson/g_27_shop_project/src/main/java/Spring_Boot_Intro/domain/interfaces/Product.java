package Spring_Boot_Intro.domain.interfaces;

public interface Product {

  int getId();

  void setId(int id);

  boolean isActive();
  void setActive(boolean isActive);

  String getName();
  void setName(String name);

  double getPrice();
  void setPrice(double price);

}
