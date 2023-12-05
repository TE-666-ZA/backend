package carECUs;

public class OnBoardControlModule {

  private EngineControlModule engineControlModule;

  private GearboxControlModule gearboxControlModule;

  public void startTheCar(){
    gearboxControlModule.switchGearToParking();
    engineControlModule.startEngine();
    System.out.println("All systems are ready, car is running. Have a good trip! ");
  }

  public EngineControlModule getEngineControlModule() {
    return engineControlModule;
  }

  public void setEngineControlModule(EngineControlModule engineControlModule) {
    this.engineControlModule = engineControlModule;
  }

  public GearboxControlModule getGearboxControlModule() {
    return gearboxControlModule;
  }

  public void setGearboxControlModule(GearboxControlModule gearboxControlModule) {
    this.gearboxControlModule = gearboxControlModule;
  }
}
