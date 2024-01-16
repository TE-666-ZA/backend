package de.aittr.homework.service;

import de.aittr.homework.domain.Car;
import de.aittr.homework.repository.CarRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarService {


  private CarRepository repository;

  public CarService(CarRepository repository) {
    this.repository = repository;
  }

  public List<Car> getAll(){
    return repository.findAll();
  }
}
