package app.code;

import app.staff.admin.Director;
import app.staff.admin.ProductionChief;
import app.staff.admin.SalesChief;
import app.staff.specialists.Secretary;
import app.staff.specialists.production.MachineOperator;
import app.staff.specialists.production.Storekeeper;
import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;

public class Application {
  public static void main(String[] args) {

    MachineOperator machineOperator = new MachineOperator();
    Storekeeper storekeeper = new Storekeeper();

    Merchandiser merchandiser = new Merchandiser();
    SalesManager salesManager = new SalesManager();

    Secretary secretary = new Secretary();

    ProductionChief productionChief = new ProductionChief();
    productionChief.setStorekeeper(storekeeper);
    productionChief.setMachineOperator(machineOperator);

    SalesChief salesChief = new SalesChief();
    salesChief.setSalesManager(salesManager);
    salesChief.setMerchandiser(merchandiser);

    Director director = new Director();
    director.setProductionChief(productionChief);
    director.setSecretary(secretary);
    director.setSalesChief(salesChief);

    director.manageCompany();
  }

}
