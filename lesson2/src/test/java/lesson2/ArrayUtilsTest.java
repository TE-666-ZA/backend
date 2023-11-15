package test.java.lesson2;

import static org.junit.jupiter.api.Assertions.*;

import main.java.lesson2.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayUtilsTest {

  private ArrayUtils utils;
  private int[] array;

  @BeforeEach
  public void init(){
    utils = new ArrayUtils();
    this.array = utils.getArrayBySize(6);
  }

  @Test
  public void checkArrayLenghtISCorrect(){
    int expected = 6;

    assertEquals(expected,array.length);
  }

  @Test
  public void expectExceptionIfArgumentIsIncorrect(){
    try {
      utils.getArrayBySize(0);
    }catch (IllegalArgumentException e){
      return;
    }
    fail();
  }

  @Test
  public void checkIArrayContainsCorrectValues(){
    int expected1 = 2;
    int expected2 = 4;
    int actual1 = array[1];
    int actual2 = array[3];
    assertEquals(expected1,actual1);
    assertEquals(expected2,actual2);
  }
  @Test
  public void getArrayReturnNotNull(){
    assertNotNull(array);
  }


}