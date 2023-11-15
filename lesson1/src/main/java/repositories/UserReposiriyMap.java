package main.java.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.domain.User;

public class UserReposiriyMap implements UserRepository {

  private Map<Long,User> database = new HashMap<>();
  private long idCounter;
  @Override
  public User getidById(long id) {
        return database.get(id);
  }

  @Override
  public List<User> getAll() {
    return  new ArrayList<>(database.values());
  }

  @Override
  public void save(User user) {
    user.setId(++idCounter);
    database.put(user.getId(),user);
  }

  @Override
  public void deleteById(long id) {
    database.remove(id);
  }

  @Override
  public void update(User user) {
    database.put(user.getId(), user);
  }

  @Override
  public User getByEmail(String email) {
    return database.values()
        .stream().filter(x -> x.getEmail().equals(email))
        .findFirst().orElse(null);
  }
}
