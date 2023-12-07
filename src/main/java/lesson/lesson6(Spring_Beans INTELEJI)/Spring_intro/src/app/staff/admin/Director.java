package app.staff.admin;

import app.staff.specialists.Secretary;
import org.springframework.beans.factory.annotation.Autowired;

public class Director {

  @Autowired
  private ProductionChief productionChief;
  @Autowired
  private SalesChief salesChief;
  @Autowired
  private Secretary secretary;

  public void manageCompany(){
    productionChief.giveOrders();
    salesChief.giveOrder();
    secretary.work();
  }
  public ProductionChief getProductionChief() {
    return productionChief;
  }

  public void setProductionChief(ProductionChief productionChief) {
    this.productionChief = productionChief;
  }

  public SalesChief getSalesChief() {
    return salesChief;
  }

  public void setSalesChief(SalesChief salesChief) {
    this.salesChief = salesChief;
  }

  public Secretary getSecretary() {
    return secretary;
  }

  public void setSecretary(Secretary secretary) {
    this.secretary = secretary;
  }
}
