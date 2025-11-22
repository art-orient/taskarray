package by.art.taskarray.factory.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.factory.SimpleArrayFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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
  @Tag("factory")
  void createSimpleArray() {
    long[] expectedArray = {1, 2, 3};
    SimpleArray actual = factory.createSimpleArray(expectedArray);
    assertAll(
            () -> assertNotNull(actual),
            () -> assertTrue(actual.getArrayId() > 0),
            () -> assertArrayEquals(expectedArray, actual.getArray())
    );
  }

  @Test
  @Tag("factory")
  void createAllSimpleArraysTest() {
    long[] array1 = new long[]{1, 2, 3};
    long[] array2 = new long[]{55, 777, -99};
    List<long[]> arrays = List.of(array1, array2);
    List<SimpleArray> actual = factory.createSimpleArrays(arrays);
    assertAll(
            () -> assertNotNull(actual),
            () -> assertTrue(actual.get(0).getArrayId() > 0),
            () -> assertArrayEquals(array1, actual.get(0).getArray()),
            () -> assertArrayEquals(array2, actual.get(1).getArray())
    );
  }
}