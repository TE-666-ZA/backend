package Spring_Boot_Intro.services.jpa;

import Spring_Boot_Intro.domain.DTO.CustomerDto;
import Spring_Boot_Intro.domain.interfaces.Product;
import Spring_Boot_Intro.domain.jpa.JpaCustomer;
import Spring_Boot_Intro.repositories.jpa.JpaCustomerRepository;
import Spring_Boot_Intro.services.interfaces.CustomerService;
import Spring_Boot_Intro.services.mapping.mapstruct.CycleAvoidingMappingContext;
import Spring_Boot_Intro.services.mapping.mapstruct.JpaCustomerMappingService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class JpaCustomerService implements CustomerService {

  private JpaCustomerRepository repository;
  private JpaCustomerMappingService mappingService;
  private CycleAvoidingMappingContext context;

  public JpaCustomerService(JpaCustomerRepository repository,
      JpaCustomerMappingService mappingService) {
    this.repository = repository;
    this.mappingService = mappingService;
    this.context = new CycleAvoidingMappingContext();
  }

  @Override
  public CustomerDto save(CustomerDto customer) {
    try {
      JpaCustomer entity = mappingService.mapDtoToJpa(customer, context);
      entity.setId(0);
      entity = repository.save(entity);
      return mappingService.mapJpaToDto(entity,context);
    } catch (Exception e) {
      throw new NoSuchElementException();
    }
  }

  @Override
  public List<CustomerDto> getAllActiveCustomers() {
  return repository.findAll().stream().filter(x -> x.isActive())
      .map(x-> mappingService.mapJpaToDto(x,context)).toList();
  }

  @Override
  public CustomerDto getActiveCustomersById(int id) {
    JpaCustomer entity = repository.findById(id).orElse(null);
    if (entity != null && entity.isActive()) {
      return mappingService.mapJpaToDto(entity,context);
    }
    throw new RuntimeException();

  }

  @Override
  public void update(CustomerDto customer) {
    repository.save(mappingService.mapDtoToJpa(customer,context));
  }

  @Override
  public void deleteById(int id) {
    try {
      JpaCustomer customer = repository.findById(id).orElse(null);
      customer.setActive(false);
      repository.save(customer);
    } catch (Exception e) {

    }
  }

  @Override
  public void deleteByName(String name) {
    try {
      JpaCustomer customer = repository.findByName(name);
      customer.setActive(false);
      repository.save(customer);
    } catch (Exception e) {

    }

  }

  @Override
  public void restoreById(int id) {
    try {
      JpaCustomer customer = repository.findById(id).orElse(null);
      customer.setId(id);
      repository.save(customer);
    } catch (Exception e) {

    }
  }

  @Override
  public int getActiveCustomersCount() {
    return repository.getActiveCustomerCount();
  }

  @Override
  public double getTotalCartPriceById(int customerId) {
    JpaCustomer customer = repository.findById(customerId).orElse(null);
    if (customer != null && customer.isActive()) {
      List<Product> products = null;
      if (!products.isEmpty()) {
        return products.stream().filter(Product::isActive)
            .mapToDouble(Product::getPrice).sum();
      }
    }
    throw new NoSuchElementException();
  }

  @Override
  public double getAveragePriceById(int customerId) {
    JpaCustomer customer = repository.findById(customerId).orElse(null);
    if (customer != null && customer.isActive()) {
      List<Product> products = null;
      if (!products.isEmpty()) {
        return products.stream().filter(Product::isActive)
            .mapToDouble(Product::getPrice).average().orElse(0.0);
      }
    }
    throw new NoSuchElementException();
  }
@Override
public void addProductToCart(int productId, int customerId) {

}

@Override
public void deleteProductFromCart(int productId, int customerId) {

}

@Override
public void clearCart(int customerId) {

}
}
