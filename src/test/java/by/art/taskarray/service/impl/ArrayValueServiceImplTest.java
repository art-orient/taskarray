package by.art.taskarray.service.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.ArrayValueService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalLong;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValueServiceImplTest {
  SimpleArray simpleArray;

  @BeforeEach
  void setUp() {
    long[] testArray = new long[]{42, 21, 5, 10, 100};
    simpleArray = new SimpleArray(1, testArray);
  }

  @AfterEach
  void tearDown() {
    simpleArray = null;
  }

  @Test
  void minPositiveTest() {
    ArrayValueService valueService = new ArrayValueServiceImpl();
    OptionalLong expected = OptionalLong.of(5);
    OptionalLong actual = valueService.min(simpleArray);
    assertEquals(expected, actual);
  }

  @Test
  void maxPositiveTest() {
    ArrayValueService valueService = new ArrayValueServiceImpl();
    OptionalLong expected = OptionalLong.of(100);
    OptionalLong actual = valueService.max(simpleArray);
    assertEquals(expected, actual);
  }

  @Test
  void sumPositiveTest() {
    ArrayValueService valueService = new ArrayValueServiceImpl();
    OptionalLong expected = OptionalLong.of(178);
    OptionalLong actual = valueService.sum(simpleArray);
    assertEquals(expected, actual);
  }
}