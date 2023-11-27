package task2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.List;
import java.util.Objects;

@JsonAutoDetect
public class Cat {

    private int age;
    private String color;
    private double weight;
    private Owner owner;
    private List<Food> food;


    public Cat() {
    }

    public Cat(int age, String color, double weight, Owner owner, List<Food> food) {
        this.age = age;
        this.color = color;
        this.weight = weight;
        this.owner = owner;
        this.food = food;
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
        return age == cat.age && Double.compare(weight, cat.weight) == 0
            && Objects.equals(color, cat.color) && Objects.equals(owner, cat.owner)
            && Objects.equals(food, cat.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, color, weight, owner, food);
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Cat: age - ");
        builder.append(age)
            .append(", color - ")
            .append(color)
            .append(", weight - ")
            .append(weight)
            .append(".\n")
            .append("    ")
            .append(owner)
            .append("\n")
            .append("    List of preference food:\n");
        for (Food currentFood : food) {
            builder.append("        ").append(currentFood).append("\n");
        }
        return builder.toString();
    }
}
