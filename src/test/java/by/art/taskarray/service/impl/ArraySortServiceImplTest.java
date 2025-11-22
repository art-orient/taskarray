package by.art.taskarray.service.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.ArraySortService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortServiceImplTest {
  ArraySortService sortService;
  SimpleArray simpleArray;
  long[] expected = {-38547, -27, 15, 42, 5842368885455L};

  @BeforeEach
  void setUp() {
    sortService = new ArraySortServiceImpl();
    long[] arrayBeforeSorting = {15, -27, 42, 5842368885455L, -38547};
    simpleArray = new SimpleArray(1, arrayBeforeSorting);
  }

  @AfterEach
  void tearDown() {
    sortService = null;
    simpleArray = null;
  }

  @Test
  @Tag("service")
  void bubbleSortTest() {
    sortService.bubbleSort(simpleArray);
    long[] actual = simpleArray.getArray();
    assertArrayEquals(expected, actual);
  }

  @Test
  @Tag("service")
  void insertionSortTest() {
    sortService.insertionSort(simpleArray);
    long[] actual = simpleArray.getArray();
    assertArrayEquals(expected, actual);
  }
}