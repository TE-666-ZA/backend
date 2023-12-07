package code;

import carECUs.OnBoardControlModule;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class mainV3SpringWithAnotation {

  public static void main(String[] args) {

    AbstractApplicationContext context = new AnnotationConfigApplicationContext("config");

    OnBoardControlModule onBoardControlModule = context.getBean(OnBoardControlModule.class);
    onBoardControlModule.startTheCar();
  }
}
