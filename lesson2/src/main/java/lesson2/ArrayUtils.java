package main.java.lesson2;

import org.junit.jupiter.api.Test;

public class ArrayUtils {

  public int[] getArrayBySize(int size){
    if (size < 1) {
     throw new IllegalArgumentException("index cant be < 1");
    }
    else {
      int[] result = new int[size];
      for (int i = 0; i < size; i++) {
        result[i] = i + 1;
      }
      return result;
    }
  }
}
