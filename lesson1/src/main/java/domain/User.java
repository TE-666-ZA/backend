package main.java.domain;

import java.util.Objects;

public class User {

  private long id;
  private String email;
  private String password;


  public User(){
      this.email = " email";
      this.password = "password";
  }
  public User(String email, String password){
      this.email = email;
      this.password = password;
  }
  public User(long id,String email, String password){
    this.id = id;
    this.email = email;
    this.password = password;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    User user = (User) object;
    return id == user.id && Objects.equals(email, user.email) && Objects.equals(
        password, user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, password);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
