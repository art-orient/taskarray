package by.art.taskarray.validator.impl;

import by.art.taskarray.validator.NumberLineValidator;

public class NumberLineValidatorImpl implements NumberLineValidator {

  @Override
  public boolean isDataLongNumber(String numbersLine) {
    return (numbersLine != null && numbersLine.matches(LONG_NUMBER_REGEX));
  }
}
