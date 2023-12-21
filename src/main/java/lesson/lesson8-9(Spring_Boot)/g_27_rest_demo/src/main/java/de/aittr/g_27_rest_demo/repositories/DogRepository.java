package de.aittr.g_27_rest_demo.repositories;

import de.aittr.g_27_rest_demo.domain.Dog;
import de.aittr.g_27_rest_demo.domain.IDog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Repository;

@Repository
public class DogRepository implements ICrudRepository<IDog>{
  private final String ID = "dog_id";
  private final String AGE = "age";
  private final String COLOR = "color";
  private final String WEIGHT = "weight";
  private final String DB_DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
  private final String DB_ADDRES = "jdbc:mysql://localhost:3306/";
  private final String DB_NAME = "animals";
  private final String DB_USERNAME = "root";
  private final String DB_PASSWORD = "lolika12";

  private Connection getConnection(){
    try {
      Class.forName(DB_DRIVER_PATH);
      String dbUrl = String.format("%s%s?user=%s&password=%s",
          DB_ADDRES,DB_NAME,DB_USERNAME,DB_PASSWORD);
      return DriverManager.getConnection(dbUrl);
    }catch (Exception e){
      throw new RuntimeException(e);
    }
  }
  @Override
  public IDog save(IDog obj) {
    try(Connection connection = getConnection()){

      String query = String.format(Locale.US , "insert into dogs (%s,%s,%s) VALUES (%d,%s,%.2f)"
          ,AGE,COLOR,WEIGHT,
          obj.getAge(),obj.getColor().toLowerCase(),obj.getWeight());

      String test = ("insert into  animals.dogs (age,color,weight)values(6,\"back\",65.36)");



       connection.createStatement().execute(query);

      return obj;

    }catch (Exception e){
      throw new RuntimeException(e);
    }
  }
  @Override
  public IDog getById(int id) {
      try(Connection connection = getConnection()){

        Statement statement = connection.createStatement();
        String query = String.format("select * from dogs where dog_id = %d" ,id);
        ResultSet resultSet = statement.executeQuery(query);

        if(resultSet.next()) {

          int age = resultSet.getInt(2);
          String color = resultSet.getNString(3);
          double weight = resultSet.getDouble(4);

          return new Dog(id, age, color, weight);
        }
        return null;

      }catch (Exception e){
        throw new RuntimeException(e);
      }

  }

  @Override
  public List<IDog> getAll() {
      try(Connection connection = getConnection()){

        String query = "select * from dogs";
        ResultSet resultSet = connection.createStatement().executeQuery(query);

        List<IDog> dogs = new ArrayList<>();

        while (resultSet.next()){

          int id = resultSet.getInt(ID);
          int age = resultSet.getInt(AGE);
          String color = resultSet.getString(COLOR);
          double weight = resultSet.getDouble(WEIGHT);

          dogs.add(new Dog(id,age,color,weight));
        }
        return dogs;
      }catch (Exception e){
        throw  new RuntimeException(e);
      }
    }

  @Override
  public void deleteById(int id) {
      try (Connection connection = getConnection()){

        String query = String.format("delete from dogs where dog_id = %d",id);
        connection.createStatement().execute(query);

      }catch (Exception e){
        throw new RuntimeException(e);
      }
  }
}

