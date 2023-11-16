package main.java.repositories;

import java.util.List;
import main.java.domain.User;

public interface CrudRepository {

  User getidById(long id);


  List<User> getAll();

  void save(User user);

  void deleteById(long id);

  void update(User user);

}
