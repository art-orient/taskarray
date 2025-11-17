package by.art.taskarray.validator.impl;

import by.art.taskarray.validator.NumberLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberLineValidatorImpl implements NumberLineValidator {
  public static final Logger logger = LogManager.getLogger();

  @Override
  public boolean isDataLongNumber(String numbersLine) {
    return numbersLine != null && numbersLine.matches(LONG_NUMBER_REGEX);
  }
}
