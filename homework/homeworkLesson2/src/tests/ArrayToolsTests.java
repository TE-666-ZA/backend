package tests;
import static org.junit.jupiter.api.Assertions.*;

import main.ArrayTools;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayToolsTests {

  private ArrayTools tools;


  @BeforeEach public void init(){
    System.out.println("test is running ");
    this.tools = new ArrayTools();
  }
  @AfterEach
  public void end(){
    System.out.println(" test is finish");
  }

  @Test
  public void findSameValuesInArraysCheckReturnLength(){
    int[] array1 = {12,-9,69,52,0,-40,6,9,45,69};
    int[] array2 = {12, 105, -9, 99, 100 , -40};
    int expectedLength = 3;
    int[] result = tools.findSameValluesIn2Arrays(array1,array2);
    assertEquals(expectedLength,result.length);

  }

}
