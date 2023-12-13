package de.aittr.g_27_rest_demo.controllers;

import de.aittr.g_27_rest_demo.domain.Cat;
import de.aittr.g_27_rest_demo.domain.ICat;
import de.aittr.g_27_rest_demo.services.CatService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/cats")
public class CatController {


  private CatService service;
  public CatController(CatService service) {
    this.service = service;
  }

  @GetMapping("/all")
  public List<ICat> getAll(){
    return  service.getAll();
  }

@PostMapping("/save")
  public ICat save(@RequestBody Cat obj){
    return  service.save(obj);
  }

  @GetMapping("/get_by_id")
  public ICat getById(@RequestParam int id){
    return service.getByID(id);
  }

  @DeleteMapping("/delete")
  public void deleteById(@RequestParam int id){
    service.deleteById(id);
  }

}
