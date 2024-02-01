package Spring_Boot_Intro.services.jdbc;

import Spring_Boot_Intro.domain.DTO.ProductDto;
import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.domain.jdbc.CommonProduct;
import Spring_Boot_Intro.repositories.interfaces.ProductRepository;
import Spring_Boot_Intro.services.interfaces.ProductService;
import Spring_Boot_Intro.services.mapping.ProductMappingService;
import java.util.List;
import java.util.NoSuchElementException;

//@Service
public  class CommonProductService implements ProductService {

  private ProductRepository repository;
  private ProductMappingService mappingService;

  public CommonProductService(ProductRepository repository, ProductMappingService mappingService) {
    this.repository = repository;
    this.mappingService = mappingService;
  }

  @Override
  public ProductDto save(ProductDto product) {
    if(product == null){
      throw new IllegalArgumentException("Product cant be null");
    }
    if(product.getName().isBlank() || product.getName().isEmpty()){
      throw new IllegalArgumentException("Product name cant be empty");
    }
    if(product.getPrice() <= 0){
      throw new IllegalArgumentException("Product price should be above -1");
    }
    Product entity = mappingService.mapDtoToCommon(product);
    entity = repository.save(entity);
    return mappingService.mapEntityToDto(entity);
  }

  @Override
  public List<ProductDto> getAllActiveProducts() {
    List<ProductDto> result = repository.getAll();
    if(result.isEmpty()){
      throw new NoSuchElementException("There is no active products in data base");
    }
    return result;
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
