package de.aittr.g_27_rest_demo.services;

import de.aittr.g_27_rest_demo.domain.Cat;
import de.aittr.g_27_rest_demo.repositories.CatRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CatService implements IService<Cat>{

  private CatRepository repository;

  public CatService(CatRepository repository) {
    this.repository = repository;
  }

  @Override
  public Cat save(Cat obj) {
    return null;
  }

  @Override
  public Cat getByID(int id) {
    return null;
  }

  @Override
  public List<Cat> getAll() {
    return new ArrayList<>(repository.getAll());
  }

  @Override
  public void deleteById(int id) {

  }
}
