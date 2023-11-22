package task2;

public class ExteptionCauseTest {

  private static int [] array = {1,2,3,4,5};

  public static void main(String[] args) {

    try {
      System.out.println(getValueByIndex(7));
    }catch (IllegalArgumentException e){
      System.out.println("Error message - " + e.getMessage());
      System.out.println("Error reason - " +e.getCause().getMessage());
    }
  }


  private static int getValueByIndex(int index) {
    try {
      return array[index];
    }catch (ArrayIndexOutOfBoundsException e){
      throw new IllegalArgumentException("Incorrect index",e);
    }
  }
}
