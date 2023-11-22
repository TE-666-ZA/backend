package comparring;

import java.util.Objects;

public class Cat implements Comparable<Cat> {

  private int age;

  private String color;

  private double weight;

  public Cat(int age, String color, double weight) {
    this.age = age;
    this.color = color;
    this.weight = weight;
  }


  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || this.getClass() != object.getClass()) {
      return false;
    }
    Cat that = (Cat) object;

    return this.age == that.age && Double.compare(this.weight, that.weight) == 0
        && Objects.equals(this.color, that.color);
  }

  @Override
  public int compareTo(Cat that) {
    int weightResult = Double.compare(this.weight, that.weight);
    if(weightResult != 0){
      return weightResult;
    }
    int ageResult = this.age - that.age;
    if(ageResult != 0){
      return ageResult;
    }
    if(this == null && that.color !=null){
      return -1;
    }
    if (this.color == null){
      return 0;
    }
    return this.color.compareTo(that.color);
  }

  @Override
  public String toString() {
    return "Cat{" +
        "age=" + age +
        ", color='" + color + '\'' +
        ", weight=" + weight +
        '}';
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }


}
