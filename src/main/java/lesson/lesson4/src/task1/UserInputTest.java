package task1;

import java.util.Scanner;

public class UserInputTest {
  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    System.out.println("Input your name");
    String name = scanner.nextLine();

    System.out.println("Input your age");
    int age = 0;

    try {
      age = Integer.parseInt(scanner.nextLine());
    }catch (Exception e){
      System.out.printf("%s - Wrong input for age !!  The default value for Age is set to 0  " + "\n",e.getMessage().split(" ")[3]);
    }

    System.out.printf("Name - %s, age - %d.", name , age);

  }
}
