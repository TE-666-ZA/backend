package de.aittr.g_27_rest_demo.controllers;

import de.aittr.g_27_rest_demo.domain.Dog;
import de.aittr.g_27_rest_demo.services.DogService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dogs")
public class DogController {

  private DogService service;

  public DogController(DogService service) {
    this.service = service;
  }

  @GetMapping("/all")
  public List<Dog> getAll(){
    return service.getAll();
  }
}
