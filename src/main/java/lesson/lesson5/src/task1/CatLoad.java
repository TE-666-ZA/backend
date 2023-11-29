package task1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileReader;

public class CatLoad {

  public static void main(String[] args) {

    File file = new File("cat.json");

    try(FileReader reader = new FileReader(file)){

      ObjectMapper mapper = new ObjectMapper();

     Cat cat = mapper.readValue(reader,Cat.class);

      System.out.println(cat);

    }catch (Exception e){
      System.out.println(e.getMessage());
    }


  }

}
