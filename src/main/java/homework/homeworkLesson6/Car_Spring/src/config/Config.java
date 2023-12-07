package config;

import carECUs.EngineControlModule;
import carECUs.GearboxControlModule;
import carECUs.OnBoardControlModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  public EngineControlModule engineControlModule(){
    return new EngineControlModule();
  }

  @Bean
  GearboxControlModule gearboxControlModule(){
    return new GearboxControlModule();
  }

  @Bean
  OnBoardControlModule onBoardControlModule(){
    return new OnBoardControlModule();
  }
}
