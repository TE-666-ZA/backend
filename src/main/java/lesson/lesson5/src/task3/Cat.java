package task3;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "cat")
@XmlRootElement
public class Cat {

    private int age;

    private String color;
    private double weight;


    public Cat() {
    }

    public Cat(int age, String color, double weight) {
        this.age = age;
        this.color = color;
        this.weight = weight;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cat cat = (Cat) object;
        return age == cat.age && Double.compare(weight, cat.weight) == 0 && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, color, weight);
    }

    @Override
    public String toString() {
        return String.format("Cat: age - %d, color - %s, weight - %.2f", age, color, weight);
    }
}
