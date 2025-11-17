package by.art.taskarray.service.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.ArraySortService;

public class ArraySortServiceImpl implements ArraySortService {
  @Override
  public void bubbleSort(SimpleArray simpleArray) {
    long[] array = simpleArray.getArray();
    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      for (int i = 1; i < array.length; i++) {
        if (array[i] < array[i - 1]){
          swap(array, i - 1, i);
          sorted = false;
        }
      }
    }
    simpleArray.setArray(array);
  }

  @Override
  public void insertionSort(SimpleArray simpleArray) {
    long[] array = simpleArray.getArray();
    for (int i = 1; i < array.length; i++) {
      long current = array[i];
      int j = i - 1;
      while (j >= 0 && current < array[j]) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = current;
    }
    simpleArray.setArray(array);
  }

  private void swap(long[] array, int index1, int index2) {
    long temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
