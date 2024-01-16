package de.aittr.homework.controller;

import de.aittr.homework.domain.Car;
import de.aittr.homework.service.CarService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

  CarService service;

  public CarController(CarService service) {
    this.service = service;
  }

  @GetMapping("/get_all")
  public List<Car> getAll(){
    return service.getAll();
  }

}
