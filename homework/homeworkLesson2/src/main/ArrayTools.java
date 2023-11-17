package main;

public class ArrayTools {

  public int[] findSameValluesIn2Arrays(int[] array1, int[] array2) {

    int size = 0;
    int[] temp = new int[array1.length];

    for (int i = 0; i < array1.length; i++) {
      for (int j = 0; j < array2.length; j++) {
        if (array1[i] == array2[j]) {
          temp[size] = array1[i];
          size++;
        }
      }
    }
    if (size < 1) {
      throw new ArrayIndexOutOfBoundsException("no common numbers was found try again!");
    }
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = temp[i];
    }
    return result;
  }


  public int[] deleteSameValuesInArray(int[] array) {
    int count = array.length;
    int savedIndex;
    int temp;

    for (int i = 0; i < count; i++) {
      for (int j = i + 1; j < count; j++) {
        if (array[j] == array[i]) {
          for (int k = j; k < array.length - 1; k++) {
            array[k] = array[k + 1];
          }
          count--;
        }
      }
    }
    int[] result = new int[count];
    for (int i = 0; i < result.length; i++) {
      result[i] = array[i];
    }

    return result;
  }


  public int FindSecondBiggestNumberInArray(int[] array) {

    int max = array[0];
    int result = array[0];

    for (int i = 0; i < array.length; ++i) {
      if (array[i] > max) {
        result = max;
        max = array[i];
      }
      if(array[i] < max && array[i] > result){
        result = array[i];
      }
    }
    return result;
  }

  public int FindSecondLowestNumberInArray(int[] array) {
    int min = array[0];
    int result = array[0];

    for (int i = 0; i < array.length; ++i) {
      if (array[i] < min) {
        result = min;
        min = array[i];
      }
      if(array[i] > min && array[i] < result){
        result = array[i];
      }
    }
    return result;
  }

}
