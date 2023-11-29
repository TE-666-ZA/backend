package task4;

import java.util.Scanner;

public class UserExceptionsTest {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Input age");
    int age = Integer.parseInt(scanner.nextLine());
    System.out.println("Your age is - " + age);


    try {
      registration(age);
    }catch (TooBigAgeExceptionChecked | TooSmallAgeExceptionUnchecked e){
      System.out.println("Error - " + e.getMessage());
    }

  }

  public static void registration(int age) throws TooBigAgeExceptionChecked{
    if(age <12){
      throw new TooSmallAgeExceptionUnchecked("Age cant be below 12");
    }
    if (age > 120){
      throw new TooBigAgeExceptionChecked("Age cant be above 120");
    }
    else{
      System.out.println("successful registration !  ");
    }
  }

}
