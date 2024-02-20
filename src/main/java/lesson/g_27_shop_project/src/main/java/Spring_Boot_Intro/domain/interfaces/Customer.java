package Spring_Boot_Intro.domain.interfaces;

public interface Customer {

  int getId();

  void setId(int id);

  boolean isActive();
  void setActive(boolean isActive);

  String getName();
  void setName(String name);
  int getAge();

  Cart getCart();
  void setCart(Cart cart);
  String getEmail();
  void setEmail(String email);


}
