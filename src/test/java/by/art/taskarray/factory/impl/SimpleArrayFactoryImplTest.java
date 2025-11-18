package by.art.taskarray.factory.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.factory.SimpleArrayFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayFactoryImplTest {
  SimpleArrayFactory factory;

  @BeforeEach
  void setUp() {
    factory = new SimpleArrayFactoryImpl();
  }

  @AfterEach
  void tearDown() {
    factory = null;
  }

  @Test
  void createSimpleArrayTest() {
    long[] expectedArray = {1, 2, 3};
    SimpleArray actual = factory.createSimpleArray(expectedArray);
    assertNotNull(actual);
    assertTrue(actual.getArrayId() > 0);
    assertArrayEquals(expectedArray, actual.getArray());
  }

  @Test
  void createAllSimpleArraysTest() {
    long[] expectedArray1 = {1, 2, 3};
    long[] expectedArray2 = {5, 7, 9};
    long[] expectedArray3 = {15, 27, 39, 44, 55};
    List<long[]> arrays = new ArrayList<>();
    arrays.add(expectedArray1);
    arrays.add(expectedArray2);
    arrays.add(expectedArray3);
    List<SimpleArray> actual = factory.createSimpleArrays(arrays);
    assertNotNull(actual);
    assertEquals(3, actual.size());
    assertTrue(actual.get(0).getArrayId() > 0);
    assertArrayEquals(expectedArray1, actual.get(0).getArray());
  }
}