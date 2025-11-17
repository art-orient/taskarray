package by.art.taskarray.validator.impl;

import by.art.taskarray.validator.NumberLineValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberLineValidatorImplTest {
  NumberLineValidator validator;
  @BeforeEach
  void setUp() {
    validator = new NumberLineValidatorImpl();
  }

  @AfterEach
  void tearDown() {
    validator = null;
  }

  @Test
  void isDataLongNumberPositiveTest() {
    String longNumbers = "55, 3555, 999999999";
    assertTrue(validator.isDataLongNumber(longNumbers));
  }

  @Test
  void isWrongDataNegativeTest() {
    String badData = "55, t3555, 99999.9999";
    assertFalse(validator.isDataLongNumber(badData));
  }

  @Test
  void isNullOrEmptyNegativeTest() {
    String empty = "";
    assertFalse(validator.isDataLongNumber(empty));
    assertFalse(validator.isDataLongNumber(null));
  }
}