package app.staff.admin;

import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;

public class SalesChief {

  private SalesManager salesManager;
  private Merchandiser merchandiser;

  public void giveOrder(){
    salesManager.work();
    merchandiser.work();
  }
  public SalesManager getSalesManager() {
    return salesManager;
  }

  public void setSalesManager(SalesManager salesManager) {
    this.salesManager = salesManager;
  }

  public Merchandiser getMerchandiser() {
    return merchandiser;
  }

  public void setMerchandiser(Merchandiser merchandiser) {
    this.merchandiser = merchandiser;
  }
}
