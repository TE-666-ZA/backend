package Spring_Boot_Intro.controllers;

import Spring_Boot_Intro.domain.jdbc.CommonCustomer;
import Spring_Boot_Intro.domain.interfaces.Customer;
import Spring_Boot_Intro.services.jdbc.CommonCustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  private CommonCustomerService service;

  public CustomerController(CommonCustomerService service) {
    this.service = service;
  }


  @GetMapping("/get_all_active")
  public List<Customer> getAllActiveCustomers(){
    return service.getAllActiveCustomers();
  }
  @PostMapping("/save")
  public Customer save (@RequestBody CommonCustomer customer){
    return service.save(customer);
  }

}
