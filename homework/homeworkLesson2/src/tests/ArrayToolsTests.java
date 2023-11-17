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
    this.correctArray1 = new int[] {12,-9,69,52,0,-40,0,6,9,0,45,69};
    this.correctArray2 = new int[] {101,12, 105, -9, 99, 100 , 12,-40};
    this.inorrectArray1 = new int[] {2};
    this.incorrectArray2 = new int[] {7,-99};
  }
  @AfterEach
  public void end(){
    System.out.println(" test is finish");


  }

  @Test
  public void findSameValuesInArraysCheckReturnLength(){
       int expectedLength = 4;
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
    }catch (ArrayIndexOutOfBoundsException e){
      return;
    }
    fail();
  }

  @Test
  public void findSameValuesIn2ArraysCheckReturnValues(){
    int expected1 = 12;
    int expceted2 = -40;
    int[] result = tools.findSameValluesIn2Arrays(correctArray1,correctArray2);
    assertEquals(expected1,result[0]);
    assertEquals(expceted2,result[3]);

  }

  @Test
  public void deleteSameValuesInArrayReturnsCorrectArrayLength(){
    int expectedLength = correctArray1.length - 3;
    int[] result = tools.deleteSameValuesInArray(correctArray1);
    assertEquals(expectedLength,result.length);
  }

  @Test
  public void deleteSameValuesInArrayReturnsSameArrayIfNothingFound(){
    int expected1 = 7;
    int expected2 = -99;
    int[] result = tools.deleteSameValuesInArray(incorrectArray2);
    assertEquals(expected1,result[0]);
    assertEquals(expected2,result[1]);
  }

  @Test
  public void deleteSameValuesInArrayReturnsNotNull(){
    assertNotNull(tools.deleteSameValuesInArray(correctArray2));
  }

  @Test
  public void FindSecondBiggestNumberInArrayReturnsCorrectValue(){
    int expected = 101;
    int result = tools.FindSecondBiggestNumberInArray(correctArray2);
    assertEquals(expected,result);
  }


}
