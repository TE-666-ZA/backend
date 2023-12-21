package de.aittr.g_27_rest_demo.services;

import de.aittr.g_27_rest_demo.domain.IDog;
import de.aittr.g_27_rest_demo.repositories.DogRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DogService implements IService<IDog> {

  private DogRepository repository;

  public DogService(DogRepository repository) {
    this.repository = repository;
  }

  @Override
  public IDog save(IDog obj) {
    return repository.save(obj);
  }

  @Override
  public IDog getByID(int id) {
    return repository.getById(id);
  }

  @Override
  public List<IDog> getAll() {
    return repository.getAll();
  }

  @Override
  public void deleteById(int id) {
      repository.deleteById(id);
  }
}
