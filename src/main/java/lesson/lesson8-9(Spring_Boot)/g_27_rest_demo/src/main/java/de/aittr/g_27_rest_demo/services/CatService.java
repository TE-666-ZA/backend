package de.aittr.g_27_rest_demo.services;

import de.aittr.g_27_rest_demo.domain.ICat;
import de.aittr.g_27_rest_demo.repositories.CatRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CatService implements IService<ICat> {

  private CatRepository repository;

  public CatService(CatRepository repository) {
    this.repository = repository;
  }

  @Override
  public ICat save(ICat obj) {
    if(obj.getAge() < 0){
      throw new IllegalArgumentException("Age cant be negative");
    }
    if (obj.getColor().isBlank() || obj.getColor().isEmpty()){
      throw new IllegalArgumentException("Color field cant be empty!");
    }
    if(obj.getWeight() <= 0.0){
      throw new IllegalArgumentException("weight cant be negative or zero!");
    }
    return repository.save(obj);
  }

  @Override
  public ICat getByID(int id) {
   return repository.getById(id);
  }

  @Override
  public List<ICat> getAll() {
    return repository.getAll();
  }

  @Override
  public void deleteById(int id) {
    id -= 1;
    if (id <= 0 || id > repository.getLastId()){
      throw new IllegalArgumentException("ID cant be negative or above the biggest number in repository");
    }
      repository.deleteById(id);
  }
}
