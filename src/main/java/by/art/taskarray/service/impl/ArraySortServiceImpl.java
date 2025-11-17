package by.art.taskarray.service.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArraySortServiceImpl implements ArraySortService {
  public static final Logger logger = LogManager.getLogger();

  @Override
  public void bubbleSort(SimpleArray simpleArray) {
    long[] array = simpleArray.getArray();
    logger.debug("Before bubble sorting - {}", Arrays.toString(array));
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
    logger.debug("After bubble sorting - {}", Arrays.toString(array));
    simpleArray.setArray(array);
  }

  @Override
  public void insertionSort(SimpleArray simpleArray) {
    long[] array = simpleArray.getArray();
    logger.debug("Before insertion sorting - {}", Arrays.toString(array));
    for (int i = 1; i < array.length; i++) {
      long current = array[i];
      int j = i - 1;
      while (j >= 0 && current < array[j]) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = current;
    }
    logger.debug("After insertion sorting - {}", Arrays.toString(array));
    simpleArray.setArray(array);
  }

  private void swap(long[] array, int index1, int index2) {
    long temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
