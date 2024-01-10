package Spring_Boot_Intro.controllers;

import Spring_Boot_Intro.domain.CommonProduct;
import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.services.interfaces.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  private ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }
  @PostMapping("/save")
  public Product save(@RequestBody CommonProduct product){
    return service.save(product);
  }
}
