package task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionTest {

  public static void main(String[] args) {

    FileReader reader;


    try {
      reader = new FileReader("lesson/lesson4/src/tas3/test.txt");

      System.out.println((char) reader.read());

      reader.close();

    }catch (FileNotFoundException e){
      System.out.println("No test.txt detected ");
    }catch (IOException e){
      System.out.println(e.getMessage() + "No correct data found in test.txt");
    }

    int x = 15;
    int y = 0;


    try {
      System.out.println(x / y);
    }catch (Exception e){
      System.out.println("W.T.F divide by 0 ? are y serious ? ");
    }
  }

}
