package de.aittr.g_27_data_jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "year")
  private int yearOfPublishing;


  public Book() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYearOfPublishing() {
    return yearOfPublishing;
  }

  public void setYearOfPublishing(int yearOfPublishing) {
    this.yearOfPublishing = yearOfPublishing;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return id == book.id && yearOfPublishing == book.yearOfPublishing && Objects.equals(
        name, book.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, yearOfPublishing);
  }
  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", yearOfPublishing=" + yearOfPublishing +
        '}';
  }
}
