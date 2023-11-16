package tests;
import static org.junit.jupiter.api.Assertions.*;

import main.ArrayTools;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayToolsTests {

  private ArrayTools tools;
  private int[] array1;
  private int[] array2;

  @BeforeEach public void init(){
    System.out.println("test is running ");
    this.tools = new ArrayTools();
    this.array1 = new int[] {12,-9,69,52,0,-40,6,9,45,69};
    this.array2 = new int[] {12, 105, -9, 99, 100 , -40};
    System.out.println("2 Arrays generated: " + "\n" + "Array 1 = " + array1 + "\n" + "Array 2 = " + array2 );
  }
  @AfterEach
  public void end(){
    System.out.println(" test is finish");


  }

  @Test
  public void findSameValuesInArraysCheckReturnLength(){
       int expectedLength = 3;
    int[] result = tools.findSameValluesIn2Arrays(array1,array2);
    assertEquals(expectedLength,result.length);

  }

  @Test
  public void findSameValuesIn2ArraysReturnNotNull(){
    assertNotNull(tools.findSameValluesIn2Arrays(array1,array2));
  }

}
