package de.aittr.g_27_rest_demo.services;

import de.aittr.g_27_rest_demo.domain.Dog;
import de.aittr.g_27_rest_demo.repositories.DogRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DogService implements ICatService<Dog> {

  private DogRepository repository;

  public DogService (DogRepository repository){
    this.repository = repository;
  }


  @Override
  public Dog save(Dog obj) {
    return repository.save(obj);
  }

  @Override
  public Dog getByID(int id) {
    return null;
  }

  @Override
  public List<Dog> getAll() {
    return new ArrayList<>(repository.getAll());
  }

  @Override
  public void deleteById(int id) {

  }
}
