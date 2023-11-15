package main.java.services;

import java.util.List;
import main.java.domain.User;
import main.java.repositories.UserReposiriyMap;
import main.java.repositories.UserRepository;

public class UserServiceImpl implements UserService{

  private UserRepository repository;

  public UserServiceImpl(UserRepository repository){
    this.repository = repository;
  }
  @Override
  public User addUser(String email, String password) {

    if(email == null || email.isEmpty()){
      throw new IllegalArgumentException("Email cant be empty!");
    }
    if (password == null || password.isEmpty()){
    throw new  IllegalArgumentException("Password cant be empty!");
    }
    if (password.length()< 5){
      throw new IllegalArgumentException( "Password should be longer then 5 characters!");
    }
    User existUser = repository.getByEmail(email);

    if (existUser != null){
      throw new IllegalArgumentException("User with this email already exists");
    }else {

      User user = new User(email, password);
      repository.save(user);
      return user;
    }
  }

  @Override
  public List<User> getAllUsers() {
     return  repository.getAll();
  }
}
