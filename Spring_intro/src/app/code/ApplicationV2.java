package app.code;

import app.staff.admin.Director;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationV2 {
  public static void main(String[] args) {

    AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    Director director =(Director) context.getBean("dir");

    director.manageCompany();
  }

}
