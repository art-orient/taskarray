package by.art.taskarray.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IdGenerator {
  public static final Logger logger = LogManager.getLogger();
  private static long counter = 1;

  private IdGenerator() {
  }

  public static long generateId() {
    logger.debug("Id was generated = {}", counter);
    return counter++;
  }
}
