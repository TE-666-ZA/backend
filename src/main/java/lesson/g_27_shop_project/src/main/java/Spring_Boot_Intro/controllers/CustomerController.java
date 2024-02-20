package Spring_Boot_Intro.controllers;

import Spring_Boot_Intro.domain.DTO.CustomerDto;
import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.domain.jdbc.CommonCustomer;
import Spring_Boot_Intro.services.interfaces.CustomerService;
import Spring_Boot_Intro.services.jdbc.CommonCustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  private CustomerService service;

  public CustomerController(CustomerService service) {
    this.service = service;
  }


  @GetMapping("/get_all")
  public List<CustomerDto> getAllActiveCustomers(){
    return service.getAllActiveCustomers();
  }
  @PostMapping("/save")
  public CustomerDto save (@RequestBody CustomerDto customer){
    return service.save(customer);
  }

  @GetMapping("/by_id/{id}")
  public CustomerDto getById(@PathVariable int id){
    return service.getActiveCustomersById(id);
  }

}
