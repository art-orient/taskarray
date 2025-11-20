package by.art.taskarray.validator.impl;

import by.art.taskarray.validator.NumberLineValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberLineValidatorImplTest {
  NumberLineValidator validator;

  static Stream<Arguments> provideLines() {
    return Stream.of(
            Arguments.of("55, 3555, 999999999"),
            Arguments.of("68425862; 5843; -876221563; 85462;2254; 8562"),
            Arguments.of("22, 03, 1972")
    );
  }

  @BeforeEach
  void setUp() {
    validator = new NumberLineValidatorImpl();
  }

  @AfterEach
  void tearDown() {
    validator = null;
  }

  @ParameterizedTest
  @MethodSource("provideLines")
  @Tag("validator")
  void isDataLongNumberPositiveTest(String input) {
    assertTrue(validator.isDataLongNumber(input));
  }

  @Test
  @Tag("validator")
  void isWrongDataNegativeTest() {
    String badData = "55, t3555, 99999.9999";
    assertFalse(validator.isDataLongNumber(badData));
  }

  @Test
  @Tag("validator")
  void isNullOrEmptyNegativeTest() {
    String empty = "";
    assertAll(
            () -> assertFalse(validator.isDataLongNumber(empty)),
            () -> assertFalse(validator.isDataLongNumber(null))
    );
  }
}