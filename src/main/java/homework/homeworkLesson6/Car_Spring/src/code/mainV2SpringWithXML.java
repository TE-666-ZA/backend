package code;

import carECUs.OnBoardControlModule;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainV2SpringWithXML {

  public static void main(String[] args) {

    AbstractApplicationContext context = new ClassPathXmlApplicationContext("car.xml");

    OnBoardControlModule onBoardControlModule = context.getBean(OnBoardControlModule.class);

    onBoardControlModule.startTheCar();

  }

}
