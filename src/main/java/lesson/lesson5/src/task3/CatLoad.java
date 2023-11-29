package task3;

import java.io.File;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class CatLoad {

  public static void main(String[] args) {

    File file = new File("cat.xml");

    try(FileReader reader = new FileReader(file)){

      JAXBContext context = JAXBContext.newInstance(Cat.class);

      Unmarshaller unmarshaller = context.createUnmarshaller();
      Object cat = unmarshaller.unmarshal(file);

      System.out.println(cat);

    }catch (Exception e){
      System.out.println(e.getMessage());
    }


  }

}
