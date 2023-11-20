package comparring;

import java.util.Set;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {

    Set<Integer> set = new TreeSet<>();

    set.add(8);
    set.add(2);
    set.add(4);
    set.add(10);
    set.add(5);
    set.add(1);
    set.add(7);
    set.add(3);

    System.out.println(set);

    Set<Cat> cats = new TreeSet<>();

    cats.add(new Cat(5,"Black",3.7));
    cats.add(new Cat(3,"Gray",4.6));
    cats.add(new Cat(9,"Gray",9.6));
    cats.add(new Cat(3,"white",4.6));
    cats.add(new Cat(4,"Gray",4.6));
    cats.add(new Cat(1,"Gray",3.5));

    cats.forEach(System.out::println);

    System.out.println();

    Set<Cat> cats1 = new TreeSet<>(new CatComparator());

    cats1.add(new Cat(5,"Black",3.7));
    cats1.add(new Cat(3,"Gray",4.6));
    cats1.add(new Cat(9,"Gray",9.6));
    cats1.add(new Cat(3,"white",4.6));
    cats1.add(new Cat(4,"Gray",4.6));
    cats1.add(new Cat(1,"Gray",3.5));

    cats1.forEach(System.out::println);

  }
}
