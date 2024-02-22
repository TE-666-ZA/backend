package Spring_Boot_Intro.services.jpa;

import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.jpa.JpaProduct;
import Spring_Boot_Intro.exception_handling.exceptions_for_test.FourthTestException;
import Spring_Boot_Intro.exception_handling.exceptions_for_test.ThirdTestException;
import Spring_Boot_Intro.repositories.jpa.JpaProductRepository;
import Spring_Boot_Intro.services.interfaces.ProductService;
import Spring_Boot_Intro.services.mapping.mapstruct.JpaListProductMappingService;
import Spring_Boot_Intro.services.mapping.mapstruct.JpaProductMappingService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JpaProductService implements ProductService {

  private JpaProductRepository repository;
  private JpaProductMappingService mappingService;
  private JpaListProductMappingService listProductMappingService;

  public JpaProductService(JpaProductRepository repository, JpaProductMappingService mappingService,
      JpaListProductMappingService listProductMappingService) {
    this.repository = repository;
    this.mappingService = mappingService;
    this.listProductMappingService = listProductMappingService;
  }

  @Override
  public ProductDto save(ProductDto product) {
    try {
      JpaProduct entity = mappingService.mapDtoToJpa(product);
      entity.setId(0);
      entity = repository.save(entity);
      return mappingService.mapJpaToDto(entity);
    } catch (Exception e) {
      throw new FourthTestException(e.getMessage());
    }

  }

  @Override
  public List<ProductDto> getAllActiveProducts() {
    return listProductMappingService.mapJpaToDto(repository.findAll().stream()
        .filter(x -> x.isActive()).toList());
  }

  @Override
  public ProductDto getActiveProductById(int id) {
    JpaProduct product = repository.findById(id).orElse(null);

    if (product != null && product.isActive()) {
      return mappingService.mapJpaToDto(product);
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
    try {
      JpaProduct product = repository.findById(id).orElse(null);
      product.setActive(false);
      repository.save(product);
    } catch (Exception e) {

    }
  }


  @Override
  public void deleteByName(String name) {
    try {
      JpaProduct product = repository.findByName(name);
      product.setActive(false);
      repository.save(product);
    } catch (Exception e) {

    }
  }

  @Override
  @Transactional
  public void restoreById(int id) {
  try{
    JpaProduct product = repository.findById(id).orElse(null);
    product.setActive(true);
    repository.save(product);
  }catch (Exception e){

  }
  }

  @Override
  public int getActiveProductsCount() {
    return repository.getActiveProductsCount();
  }

  @Override
  public double getActiveProductsTotalPrice() {
    return repository.getActiveProductsTotalPrice();
  }

  @Override
  public double getActiveProductAveragePrice() {
    return repository.getActiveProductAveragePrice();
  }
}
