package de.aittr.g_27_rest_demo.domain;

import java.util.Objects;


public class Cat implements IPet {

  private int id;
  private int age;
  private String color;
  private double weight;

  public Cat(int age, String color, double weight) {
    this.age = age;
    this.color = color;
    this.weight = weight;
  }

  public Cat(int id, int age, String color, double weight) {
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
    Cat cat = (Cat) object;
    return id == cat.id && age == cat.age && Double.compare(weight, cat.weight) == 0
        && Objects.equals(color, cat.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, age, color, weight);
  }

  @Override
  public String toString() {
    return "Cat{" +
        "id=" + id +
        ", age=" + age +
        ", color='" + color + '\'' +
        ", weight=" + weight +
        '}';
  }
}
