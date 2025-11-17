package by.art.taskarray.factory.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.factory.SimpleArrayFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
  void createSimpleArrayTest() {
    long[] expectedArray = {1, 2, 3};
    List<SimpleArray> actual = factory.createSimpleArray("data/data.txt");
    System.out.println(actual.size());
    assertNotNull(actual);
    assertEquals(4, actual.size());
    assertTrue(actual.get(0).getArrayId() > 0);
    assertArrayEquals(expectedArray, actual.get(0).getArray());
  }
}