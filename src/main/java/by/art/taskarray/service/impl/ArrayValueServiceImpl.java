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
    return calculate(simpleArray, Operation.MIN);
  }

  @Override
  public OptionalLong max(SimpleArray simpleArray) {
    return calculate(simpleArray, Operation.MAX);
  }

  @Override
  public OptionalLong sum(SimpleArray simpleArray) {
    return calculate(simpleArray, Operation.SUM);
  }

  private OptionalLong calculate(SimpleArray simpleArray, Operation operation) {
    if (isArrayNullOrEmpty(simpleArray)) {
      return OptionalLong.empty();
    }
    long[] array = simpleArray.getArray();
    long result = switch (operation) {
      case MIN -> {
        long min = array[0];
        for (long value : array) {
          if (value < min) {
            min = value;
          }
        }
        logger.debug("Minimum = {}", min);
        yield min;
      }
      case MAX -> {
        long max = array[0];
        for (long value : array) {
          if (value > max) {
            max = value;
          }
        }
        logger.debug("Maximum = {}", max);
        yield max;
      }
      case SUM -> {
        long sum = 0;
        for (long value : array) {
          sum += value;
        }
        logger.debug("Sum = {}", sum);
        yield sum;
      }
    };
    return OptionalLong.of(result);
  }

  private boolean isArrayNullOrEmpty(SimpleArray simpleArray) {
    boolean isNullOrEmpty = false;
    if(simpleArray == null) {
      logger.warn("SimpleArray is null");
      isNullOrEmpty = true;
    } else if(simpleArray.getArray() == null || simpleArray.getArray().length == 0) {
      logger.warn("Array is null or empty");
      isNullOrEmpty = true;
    }
    return isNullOrEmpty;
  }

  private enum Operation {
    MIN, MAX, SUM
  }
}
