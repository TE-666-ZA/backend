package app.staff.admin;

import app.staff.specialists.production.MachineOperator;
import app.staff.specialists.production.Storekeeper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductionChief {
  @Autowired
  private MachineOperator machineOperator;
  @Autowired
  private Storekeeper storekeeper;

  public void giveOrders(){
    machineOperator.work();
    storekeeper.work();
  }
  public MachineOperator getMachineOperator() {
    return machineOperator;
  }

  public void setMachineOperator(MachineOperator machineOperator) {
    this.machineOperator = machineOperator;
  }

  public Storekeeper getStorekeeper() {
    return storekeeper;
  }

  public void setStorekeeper(Storekeeper storekeeper) {
    this.storekeeper = storekeeper;
  }
}
