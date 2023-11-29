package task4;

import java.util.Objects;

public class Food {

  private String label;
  private  int requiredQuantity;


  public Food(){

  }

  public Food(String label, int requiredQuantity) {
    this.label = label;
    this.requiredQuantity = requiredQuantity;
  }


  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public int getRequiredQuantity() {
    return requiredQuantity;
  }

  public void setRequiredQuantity(int requiredQuantity) {
    this.requiredQuantity = requiredQuantity;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Food food = (Food) object;
    return requiredQuantity == food.requiredQuantity && Objects.equals(label, food.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, requiredQuantity);
  }

  @Override
  public String toString(){
    return String.format("Food: title - %s, RequiredQuantity - %d",label,requiredQuantity);
  }
}
