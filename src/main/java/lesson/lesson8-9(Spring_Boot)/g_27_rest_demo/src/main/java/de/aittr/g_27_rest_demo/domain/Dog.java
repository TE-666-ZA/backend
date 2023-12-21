package de.aittr.g_27_rest_demo.domain;

import java.util.Objects;

public class Dog implements ICat {

  private int id;
  private int age;
  private String color;
  private double weight;

  public Dog(int age, String color, double weight) {
    this.age = age;
    this.color = color;
    this.weight = weight;
  }

  public Dog(int id, int age, String color, double weight) {
    this.id = id;
    this.age = age;
    this.color = color;
    this.weight = weight;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public int getAge() {
    return age;
  }

  @Override
  public String getColor() {
    return color;
  }

  @Override
  public double getWeight() {
    return weight;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Dog dog = (Dog) object;
    return id == dog.id && age == dog.age && Double.compare(weight, dog.weight) == 0
        && Objects.equals(color, dog.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, age, color, weight);
  }

  @Override
  public String toString() {
    return "Dog{" +
        "id=" + id +
        ", age=" + age +
        ", color='" + color + '\'' +
        ", weight=" + weight +
        '}';
  }
}
