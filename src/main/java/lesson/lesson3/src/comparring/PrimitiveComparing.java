package comparring;

public class PrimitiveComparing {

  public static void main(String[] args) {

    int x = 5;
    int y = 10;
    int z = 5;

    boolean result = x == y;

    System.out.println("x & y comparing result = " + result);

    result = x == z;

    System.out.println("x & z comparing result = " + result);

    Integer integer = 5;

    result = x == integer;

    System.out.println("x & integer comparing result = " + result);

    String s = "5";


    Cat cat1 = new Cat(3,"Black", 4.5);
    Cat cat2 = new Cat(3,"Black", 4.5);

    result = cat1.equals(cat2);
    System.out.println("comparing cat1 & cat 2 = " + result);




  }


}
