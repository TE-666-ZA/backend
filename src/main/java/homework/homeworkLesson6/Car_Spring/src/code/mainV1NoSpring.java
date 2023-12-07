package code;

import carECUs.EngineControlModule;
import carECUs.GearboxControlModule;
import carECUs.OnBoardControlModule;

public class mainV1NoSpring {

  public static void main(String[] args) {

    GearboxControlModule gearboxControlModule = new GearboxControlModule();
    EngineControlModule engineControlModule = new EngineControlModule();

    OnBoardControlModule onBoardControlModule = new OnBoardControlModule();
    onBoardControlModule.setGearboxControlModule(gearboxControlModule);
    onBoardControlModule.setEngineControlModule(engineControlModule);


    onBoardControlModule.startTheCar();
  }

}
