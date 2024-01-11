package Spring_Boot_Intro.domain.interfaces;

public interface Customer {

  int getId();

  void setId(int id);

  boolean isActive();

  String getName();

  Cart getCart();
  void setCart(Cart cart);

}
