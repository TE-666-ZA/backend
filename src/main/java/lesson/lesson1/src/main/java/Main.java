package main.java;

import java.util.Scanner;
import main.java.controllers.UserController;
import main.java.repositories.UserReposiriyMap;
import main.java.repositories.UserRepository;
import main.java.services.UserService;
import main.java.services.UserServiceImpl;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    UserRepository repository = new UserReposiriyMap();
    UserService  service = new UserServiceImpl(repository);
    UserController controller = new UserController(service,scanner);


    while (true){
      System.out.println("chose operation ");
      System.out.println("1 register new user ");
      System.out.println("2 get all users");
      System.out.println("0 exit ");


      String input = scanner.nextLine();

      switch (input){
        case "0":
          System.out.printf("process Ending");
          return;

        case "1":
          try {
            controller.addUser();
          }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
          }
          break;

        case "2":
          System.out.println("all users list");
          controller.getAllUsers();
          break;
        default:
          System.out.println("incorrect input");
          break;

      }


    }
  }

}
