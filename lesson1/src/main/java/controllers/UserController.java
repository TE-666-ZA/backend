package main.java.controllers;

import java.util.List;
import java.util.Scanner;
import main.java.domain.User;
import main.java.services.UserService;

public class UserController {

  private UserService service;
  private Scanner scanner;


  public UserController(UserService service, Scanner scanner){
    this.scanner = scanner;
    this.service = service;
  }

  public void addUser(){

    System.out.println("please insert your email");
    String email = scanner.nextLine();

    System.out.println("Please insert your password");
    String password = scanner.nextLine();

   User user =  service.addUser(email,password);
   System.out.println("User added!");
   System.out.println(user);
  }


  public void getAllUsers(){
    List<User> users = service.getAllUsers();
      users.forEach(System.out::println);
  }
}
