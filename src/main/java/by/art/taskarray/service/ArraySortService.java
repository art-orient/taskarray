package by.art.taskarray.service;

import by.art.taskarray.entity.SimpleArray;

public interface ArraySortService {

  SimpleArray bubbleSort(SimpleArray array);

  SimpleArray insertionSort(SimpleArray array);
}
