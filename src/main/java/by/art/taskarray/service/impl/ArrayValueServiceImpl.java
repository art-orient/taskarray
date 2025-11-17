package by.art.taskarray.service.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.ArrayValueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.OptionalLong;

public class ArrayValueServiceImpl implements ArrayValueService {
  public static final Logger logger = LogManager.getLogger();

  @Override
  public OptionalLong min(SimpleArray simpleArray) {
    if (isArrayNull(simpleArray)) {
      return OptionalLong.empty();
    }
    long[] array = simpleArray.getArray();
    long min = array[0];
    for (long number : array) {
      if (number < min) {
        min = number;
      }
    }
    logger.debug("Minimum = {}", min);
    return OptionalLong.of(min);
  }

  @Override
  public OptionalLong max(SimpleArray simpleArray) {
    if (isArrayNull(simpleArray)) {
      return OptionalLong.empty();
    }
    long[] array = simpleArray.getArray();
    long max = array[0];
    for (long number : array) {
      if (number > max) {
        max = number;
      }
    }
    logger.debug("Maximum = {}", max);
    return OptionalLong.of(max);
  }

  @Override
  public OptionalLong sum(SimpleArray simpleArray) {
    if (isArrayNull(simpleArray)) {
      return OptionalLong.empty();
    }
    long[] array = simpleArray.getArray();
    long sum = 0;
    for (long number : array) {
      sum += number;
    }
    logger.debug("Sum = {}", sum);
    return OptionalLong.of(sum);
  }

  private boolean isArrayNull(SimpleArray simpleArray) {
    if(simpleArray == null) {
      logger.warn("SimpleArray is null");
      return true;
    } else if(simpleArray.getArray() == null || simpleArray.getArray().length == 0) {
      logger.warn("Array is null or empty");
      return true;
    }
    return false;
  }
}
