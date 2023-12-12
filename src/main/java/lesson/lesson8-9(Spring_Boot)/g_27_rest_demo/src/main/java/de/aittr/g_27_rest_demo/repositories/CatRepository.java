package de.aittr.g_27_rest_demo.repositories;

import de.aittr.g_27_rest_demo.domain.Cat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CatRepository implements ICrudRepository<Cat> {

  final private String DELIMITER = ";";
  private File file = new File("cat.txt");
  private int lastId;

  public CatRepository() {
    readLastId();
    System.out.println(lastId);
  }


  private void readLastId(){
    try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
      List<String> lines = reader.lines().toList();
      if(lines.isEmpty()){
        this.lastId = 0;
      }else {
       String[] lastLine = lines.getLast().split(DELIMITER);
        this.lastId = Integer.parseInt(lastLine[0]);
      }

    }catch (Exception e){
      throw new RuntimeException(e);
    }
  }

  @Override
  public Cat save(Cat obj) {
    this.lastId++;
      obj.setId(this.lastId);

    StringBuilder catToSave = new StringBuilder()
        .append(obj.getId())
        .append(DELIMITER)
        .append(obj.getAge())
        .append(DELIMITER)
        .append(obj.getColor().toLowerCase())
        .append(DELIMITER)
        .append(obj.getWeight())
        .append("\n");
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))){
      writer.write(catToSave.toString());
    }catch (Exception e){
      throw new RuntimeException(e);
    }
    return obj;
  }

   @Override
  public Cat getById(int id) {
    return null;
  }

  @Override
  public List<Cat> getAll() {
    try(BufferedReader reader = new BufferedReader(new FileReader(file))){
     return reader.lines()
         .map(line -> line.split(DELIMITER))
         .map(array -> new Cat(
             Integer.parseInt(array[0]),
             Integer.parseInt(array[1]),
             array[2],
             Double.parseDouble(array[3])
         ))
         .toList();
    }catch (Exception e){
      throw new RuntimeException(e);
    }
  }

  @Override
  public void deleteById(int id) {

  }
}
