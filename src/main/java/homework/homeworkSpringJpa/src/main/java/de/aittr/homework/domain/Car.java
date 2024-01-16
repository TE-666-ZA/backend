package de.aittr.homework.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "brand")
  private String brand;
  @Column(name = "model")
  private String model;
  @Column(name = "year")
  private int year;


  public Car() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return id == car.id && year == car.year && Objects.equals(brand, car.brand)
        && Objects.equals(model, car.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, brand, model, year);
  }

  @Override
  public String toString() {
    return "Car{" +
        "id=" + id +
        ", brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        '}';
  }

}
