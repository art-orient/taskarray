package by.art.taskarray.service.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.ArrayValueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalLong;

public class ArrayValueServiceImpl implements ArrayValueService {
  public static final Logger logger = LogManager.getLogger();

  @Override
  public OptionalLong min(SimpleArray simpleArray) {
    OptionalLong min = Arrays.stream(simpleArray.getArray())
                       .min();
    logger.debug("Min = {}", min);
    return min;
  }

  @Override
  public OptionalLong max(SimpleArray simpleArray) {
    OptionalLong max = Arrays.stream(simpleArray.getArray())
            .max();
    logger.debug("Min = {}", max);
    return max;
  }

  @Override
  public OptionalLong sum(SimpleArray simpleArray) {
    long sum = Arrays.stream(simpleArray.getArray())
            .sum();
    logger.debug("Sum = {}", sum);
    return OptionalLong.of(sum);
  }
}

