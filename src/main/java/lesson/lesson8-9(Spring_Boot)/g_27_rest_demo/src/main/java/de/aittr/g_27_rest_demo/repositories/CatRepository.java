package de.aittr.g_27_rest_demo.repositories;

import de.aittr.g_27_rest_demo.domain.Cat;
import de.aittr.g_27_rest_demo.domain.ICat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class CatRepository implements ICrudRepository<ICat> {

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
  public ICat save(ICat obj) {
      obj.setId(++lastId);

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
  public ICat getById(int id) {
     return getAll().stream()
         .filter(x -> x.getId() == id)
         .findFirst()
         .orElseThrow(() -> new NoSuchElementException("Pet with ID " + id + " not found"));
  }

  @Override
  public List<ICat> getAll() {
    try(BufferedReader reader = new BufferedReader(new FileReader(file))){
     return new ArrayList(reader.lines()
         .map(line -> line.split(DELIMITER))
         .map(array -> new Cat(
             Integer.parseInt(array[0]),
             Integer.parseInt(array[1]),
             array[2],
             Double.parseDouble(array[3])
         ) {
         })
         .toList()) ;
    }catch (Exception e){
      throw new RuntimeException(e);
    }
  }

  @Override
  public void deleteById(int id) {
    List<ICat> cats = getAll();
    cats.remove(cats.get(id));
    String result = cats.stream()
        .map(x -> new StringBuilder()
            .append(x.getId())
            .append(DELIMITER)
            .append(x.getAge())
            .append(DELIMITER)
            .append(x.getColor().toLowerCase())
            .append(DELIMITER)
            .append(x.getWeight())
            .append("\n")).collect(Collectors.joining());


    try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)) ){
      writer.write(result);
    }catch (Exception e){
      throw new RuntimeException(e);
    }
  }
  public int getLastId() {
    return lastId;
  }
}
