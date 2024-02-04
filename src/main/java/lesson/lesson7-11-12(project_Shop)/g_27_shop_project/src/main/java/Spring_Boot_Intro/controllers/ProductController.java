package Spring_Boot_Intro.controllers;

import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.services.interfaces.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public ProductDto save(@RequestBody ProductDto product){
    return service.save(product);
  }

  @GetMapping("/get_all")
  public List<ProductDto> getAll(){
   return service.getAllActiveProducts();
  }

  @GetMapping("/get_by_id/{id}")
  public ProductDto getById(@PathVariable int id){
    return service.getActiveProductById(id);
  }

  @PutMapping("/update")
  public void update (@RequestBody ProductDto productDto){
    service.update(productDto);
  }

  @GetMapping("/restore/{id}")
  public void restoreById(@PathVariable int id){
    service.restoreById(id);
  }


}
