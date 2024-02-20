package Spring_Boot_Intro.services.jdbc;

import Spring_Boot_Intro.domain.DTO.CustomerDto;
import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.domain.jdbc.CommonCustomer;
import Spring_Boot_Intro.repositories.jdbc.CommonCustomerRepository;
import Spring_Boot_Intro.services.interfaces.CustomerService;
import Spring_Boot_Intro.services.mapping.old.CartMappingService;
import Spring_Boot_Intro.services.mapping.old.CustomerMappingService;
import java.util.List;
import java.util.NoSuchElementException;

//@Service
public class CommonCustomerService implements CustomerService {

  private CommonCustomerRepository repository;
  private CustomerMappingService customerMappingService;
  private CartMappingService cartMappingService;

  public CommonCustomerService(CommonCustomerRepository repository,
      CustomerMappingService customerMappingService, CartMappingService cartMappingService) {
    this.repository = repository;
    this.customerMappingService = customerMappingService;
    this.cartMappingService = cartMappingService;
  }

  @Override
  public CustomerDto save(CustomerDto customer) {
    if(customer.getName().isEmpty() || customer.getName().isBlank()){
      throw new IllegalArgumentException("Customer name cant be empty");
    }
   CommonCustomer entity =  customerMappingService.mapDtoToCommon(customer);
    repository.save(entity);
    return customerMappingService.mapEntityToDto(entity);
  }

  @Override
  public List<CustomerDto> getAllActiveCustomers() {
    List<Customer> entity = repository.getAll();
    if(entity.isEmpty()){
      throw new NoSuchElementException("There is no active products");
    }
   // List<CustomerDto> result = entity.stream().map(x -> new CustomerDto(x.getId(), x.isActive(),
   //     x.getName(), x.getEmail(), x.getAge(),
   //     cartMappingService(x.getCart())).toList();
    return result;
  }

  @Override
  public CustomerDto getActiveCustomersById(int id) {
    return null;
  }

  @Override
  public void update(CustomerDto Customer) {

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
  public int getActiveCustomersCount() {
    return 0;
  }

  @Override
  public double getTotalCartPriceById(int customerId) {
    return 0;
  }

  @Override
  public double getAveragePriceById(int customerId) {
    return 0;
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
