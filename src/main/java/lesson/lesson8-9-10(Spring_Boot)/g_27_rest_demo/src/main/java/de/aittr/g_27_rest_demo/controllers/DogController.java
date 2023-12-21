package de.aittr.g_27_rest_demo.controllers;

import de.aittr.g_27_rest_demo.domain.Dog;
import de.aittr.g_27_rest_demo.domain.IDog;
import de.aittr.g_27_rest_demo.services.DogService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dogs")
public class DogController {

  private DogService service;

  public DogController(DogService service) {
    this.service = service;
  }

  @GetMapping("/get_by_id/{id}")
  public IDog getById(@PathVariable int id){
    return service.getByID(id);
  }

  @GetMapping("/all")
  public List<IDog> getAll(){
    return service.getAll();
  }


  @DeleteMapping("/delete/{id}")
  public void deleteById (@PathVariable int id){
    service.deleteById(id);
  }

  @PostMapping("/save")
  public IDog save (@RequestBody Dog obj){
    return service.save(obj);
  }

}
