package by.art.taskarray.parser.impl;

import by.art.taskarray.parser.LongNumberParser;
import by.art.taskarray.validator.NumberLineValidator;
import by.art.taskarray.validator.impl.NumberLineValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongNumberParserImpl implements LongNumberParser {
  public static final Logger logger = LogManager.getLogger();

  @Override
  public List<long[]> parseNumberLine(List<String> numberLines) {
    NumberLineValidator validator = new NumberLineValidatorImpl();
    List<long[]> result = new ArrayList<>();
    for (String line : numberLines) {
      if (line.isBlank() || !validator.isDataLongNumber(line)) {
        logger.warn("Incorrect data - {}", line);
        continue;
      }
      String[] numbers = line.strip().split(SEPARATOR_REGEX);
      long[] currentArray = Arrays.stream(numbers)
                              .mapToLong(Long::parseLong)
                              .toArray();
      logger.debug("Array is created - {}", Arrays.toString(currentArray));
      result.add(currentArray);
    }
    logger.info("Parsing is done");
    return result;
  }
}
