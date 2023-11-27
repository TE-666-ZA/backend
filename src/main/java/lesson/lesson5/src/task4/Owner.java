package task4;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "owner")
@XmlAccessorType(XmlAccessType.FIELD)
public class Owner {

  @XmlAttribute(name = "first_name")
  private String name;

  @XmlElement(name = "cellphone")
  private String phoneNumber;

  public Owner() {
  }

  public Owner(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Owner owner = (Owner) object;
    return Objects.equals(name, owner.name) && Objects.equals(phoneNumber,
        owner.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, phoneNumber);
  }

  @Override
  public String toString() {
    return String.format("Owner: name - %s, phone number - %s.",name,phoneNumber);
  }


}
