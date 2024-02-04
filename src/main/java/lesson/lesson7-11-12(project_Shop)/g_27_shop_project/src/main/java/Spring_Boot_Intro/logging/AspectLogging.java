package Spring_Boot_Intro.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

  private Logger logger = LoggerFactory.getLogger(AspectLogging.class);

  @Pointcut("execution(* de.aittr.g_27_shop_project.services.jpa." +
      "JpaProductService.getAllActiveProducts(..))")
  public void getProducts() {}

  @Before("getProducts()")
  public void beforeGetProduct(JoinPoint joinPoint) {
    logger.info("Вызван метод getAllActiveProducts");
  }

  @Pointcut("execution(* de.aittr.g_27_shop_project.services.jpa." +
      "JpaProductService.restoreById(..))")
  public void restore() {}

  @After("restore()")
  public void afterRestore(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    logger.info(String.format("The restoreById method is called with a parameter %s", args[0]));
  }

  @Pointcut("execution(* de.aittr.g_27_shop_project.services.jpa." +
      "JpaProductService.getActiveProductById(..))")
  public void getProduct() {}

  @AfterReturning(
      pointcut = "getProduct()",
      returning = "result"
  )
  public void afterReturningProduct(Object result) {
    logger.info(String.format("The getActiveProductById method successfully returned the object %s", result));
  }

  @AfterThrowing(
      pointcut = "getProduct()",
      throwing = "e"
  )
  public void afterThrowing(Exception e) {
    logger.info(String.format("The getActiveProductById method threw an exception %s", e.getMessage()));
  }
}