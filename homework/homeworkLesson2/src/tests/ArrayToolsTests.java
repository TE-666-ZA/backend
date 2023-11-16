package tests;
import static org.junit.jupiter.api.Assertions.*;

import main.ArrayTools;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayToolsTests {

  private ArrayTools tools;
  private int[] correctArray1;
  private int[] correctArray2;
  private int[] inorrectArray1;
  private int[] incorrectArray2;

  @BeforeEach public void init(){
    System.out.println("test is running ");
    this.tools = new ArrayTools();
    this.correctArray1 = new int[] {12,-9,69,52,0,-40,6,9,45,69};
    this.correctArray2 = new int[] {12, 105, -9, 99, 100 , -40};
    this.inorrectArray1 = new int[] {2};
    this.incorrectArray2 = new int[] {7,-99};
    System.out.println("4 Arrays generated: " + "\n" + "Correct array 1 = " + correctArray1 + "\n" + "Correct array 2 = " + correctArray2);
    System.out.println("Incorrect array 1 = " + inorrectArray1 + "Incorrect array 2 = " + incorrectArray2);

  }
  @AfterEach
  public void end(){
    System.out.println(" test is finish");


  }

  @Test
  public void findSameValuesInArraysCheckReturnLength(){
       int expectedLength = 3;
    int[] result = tools.findSameValluesIn2Arrays(correctArray1, correctArray2);
    assertEquals(expectedLength,result.length);

  }

  @Test
  public void findSameValuesIn2ArraysReturnNotNull(){
    assertNotNull(tools.findSameValluesIn2Arrays(correctArray1, correctArray2));
  }

  @Test
  public void findSameValuesIn2ArraysThrowErrorIfNoCommonValuesFind(){
    try{
      tools.findSameValluesIn2Arrays(inorrectArray1,incorrectArray2);
    }catch (ArrayStoreException e){
      return;
    }
    fail();
  }

  @Test
  public void findSameValuesIn2ArraysCheckReturnValues(){
    int[] expectedArrayReturn = {12,-9,-40};
    int[] temp = tools.findSameValluesIn2Arrays(correctArray1,correctArray2);
    int actualCorrectCounter = 0;
    int expectedCorrectCounter = 3;
    for(int i = 0; i < expectedArrayReturn.length; i++){
      if(expectedArrayReturn[i] == temp[i]){
        actualCorrectCounter++;
      }
    }
    assertEquals(expectedCorrectCounter,actualCorrectCounter);
  }

}
