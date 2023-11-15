package main.java.repositories;

import main.java.domain.User;

public interface UserRepository extends CrudRepository{

  User getByEmail(String email);

}
