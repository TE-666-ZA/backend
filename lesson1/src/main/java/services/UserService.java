package main.java.services;

import java.util.List;
import main.java.domain.User;

public interface UserService {

  User addUser(String email, String password);

  List<User> getAllUsers();

}
