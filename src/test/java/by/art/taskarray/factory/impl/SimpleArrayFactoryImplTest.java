package by.art.taskarray.factory.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.factory.SimpleArrayFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayFactoryImplTest {
  SimpleArrayFactory factory;

  static Stream<Arguments> provideArrays() {
    return Stream.of(
            Arguments.of(new long[]{1, 2, 3}),
            Arguments.of(new long[]{5, 7, 9}),
            Arguments.of(new long[]{15, 27, 39, 44, 55})
    );
  }

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

  @ParameterizedTest
  @MethodSource("provideArrays")
  @Tag("factory")
  void createAllSimpleArraysTest(long[] array) {
    long[] expected = array.clone();
    SimpleArray actual = factory.createSimpleArray(array);
    assertAll(
            () -> assertNotNull(actual),
            () -> assertTrue(actual.getArrayId() > 0),
            () -> assertTrue(actual.getArray().length > 0),
            () -> assertArrayEquals(expected, actual.getArray())
    );
  }
}