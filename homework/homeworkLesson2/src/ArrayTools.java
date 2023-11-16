public class ArrayTools {

  public int[] findSameValluesIn2Arrays(int[] array1, int[] array2) {

    int size = 0;
    int[] temp = new int[array1.length];

    for (int i = 0; i < array1.length; i++) {
      for (int j = 0; j < array2.length; i++) {
        if (array1[i] == array2[j]) {
          temp[size] = array1[i];
          size++;
        }
      }
    }
    if (size < 1) {
      throw new IndexOutOfBoundsException("no common numbers was found try again!");
    }
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = temp[i];
    }
    return result;
  }


  public int[] deleteSameValuesInArrays(int[] array) {
    int[] result = new int[0];

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; i++) {
        if (array[i] == array[j]) {
          result = new int[array.length - 1];
          for (int q = 0; q < array.length - 1; j++) {
            if (q != j) {
              result[q] = array[q];
            }
          }
        }
      }
    }
    return result;
  }
}


