package by.art.taskarray.validator;

public interface NumberLineValidator {
  String LONG_NUMBER_REGEX = "^\\s*[-+]?\\d+([;,]*\\s*[-+]?\\d+)*\\s*$";

  boolean isDataLongNumber(String numbersLine);
}
