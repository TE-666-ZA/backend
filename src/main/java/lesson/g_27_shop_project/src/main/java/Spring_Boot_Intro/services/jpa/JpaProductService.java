package Spring_Boot_Intro.services.jpa;

import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.domain.jpa.JpaProduct;
import Spring_Boot_Intro.exception_handling.exceptions.FirstTestException;
import Spring_Boot_Intro.exception_handling.exceptions.FourthTestException;
import Spring_Boot_Intro.exception_handling.exceptions.SecondTestException;
import Spring_Boot_Intro.exception_handling.exceptions.ThirdTestException;
import Spring_Boot_Intro.repositories.jpa.JpaProductRepository;
import Spring_Boot_Intro.services.interfaces.ProductService;
import Spring_Boot_Intro.services.mapping.ProductMappingService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
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
    try {
      JpaProduct entity = mappingService.mapDtoToJpa(product);
      entity.setId(0);
      entity = repository.save(entity);
      return mappingService.mapEntityToDto(entity);
    }catch (Exception e){
      throw new FourthTestException(e.getMessage());
    }

  }

  @Override
  public List<ProductDto> getAllActiveProducts() {
    return repository.findAll()
        .stream()
        .filter(x -> x.isActive())
        .map(x -> mappingService.mapEntityToDto(x))
        .toList();
  }

  @Override
  public ProductDto getActiveProductById(int id) {
    JpaProduct product = repository.findById(id).orElse(null);

    if (product != null && product.isActive()) {
      return mappingService.mapEntityToDto(product);
    }
    throw new ThirdTestException("Product with id " + id + " does not exist in data base");
  }

  @Override
  public void update(ProductDto product) {
    JpaProduct entity = mappingService.mapDtoToJpa(product);
    repository.save(entity);
  }

  @Override
  public void deleteById(int id) {

  }

  @Override
  public void deleteByName(String name) {

  }

  @Override
  @Transactional
  public void restoreById(int id) {
    JpaProduct product = repository.findById(id).orElse(null);

    if (product != null) {
      product.setActive(true);
    }
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
