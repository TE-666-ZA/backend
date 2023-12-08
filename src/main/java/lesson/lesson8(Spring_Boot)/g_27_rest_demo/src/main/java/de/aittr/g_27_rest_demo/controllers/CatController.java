package de.aittr.g_27_rest_demo.controllers;

import de.aittr.g_27_rest_demo.domain.Cat;
import de.aittr.g_27_rest_demo.services.CatService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/cats")
public class CatController {


  private CatService service;
  public CatController(CatService service) {
    this.service = service;
  }

  @GetMapping("/all")
  public List<Cat> getAll(){
    return service.getAll();
  }

}