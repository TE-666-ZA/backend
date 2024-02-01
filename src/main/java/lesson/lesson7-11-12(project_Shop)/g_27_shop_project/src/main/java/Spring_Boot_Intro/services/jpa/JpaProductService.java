package Spring_Boot_Intro.services.jpa;

import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.domain.jpa.JpaProduct;
import Spring_Boot_Intro.repositories.jpa.JpaProductRepository;
import Spring_Boot_Intro.services.interfaces.ProductService;
import Spring_Boot_Intro.services.mapping.ProductMappingService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JpaProductService implements ProductService {

  private JpaProductRepository repository;
  private ProductMappingService mappingService;

  public JpaProductService(JpaProductRepository repository, ProductMappingService mappingService) {
    this.repository = repository;
    this.mappingService = mappingService;
  }

  @Override
  public ProductDto save(ProductDto product) {
   JpaProduct entity = mappingService.mapDtoToJpa(product);
   entity = repository.save(entity);
   return mappingService.mapEntityToDto(entity);
  }

  @Override
  public List<ProductDto> getAllActiveProducts() {
    return null;
  }

  @Override
  public ProductDto getActiveProductById(int id) {
    return null;
  }

  @Override
  public void update(ProductDto product) {

  }

  @Override
  public void deleteById(int id) {

  }

  @Override
  public void deleteByName(String name) {

  }

  @Override
  public void restoreById(int id) {

  }

  @Override
  public int getActiveProductsCount() {
    return 0;
  }

  @Override
  public double getActiveProductsTotalPrice() {
    return 0;
  }

  @Override
  public double getActiveProductAveragePrice() {
    return 0;
  }
}
