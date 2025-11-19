package by.art.taskarray.warehouse;

import by.art.taskarray.statistic.SimpleArrayStatistic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Optional;

public class Warehouse {
  private static final Logger logger = LogManager.getLogger();
  private static Warehouse instance;
  private HashMap<Long, SimpleArrayStatistic> parameters;

  private Warehouse() {
  }

  public static Warehouse getInstance() {
    if (instance == null) {
      instance = new Warehouse();
    }
    return instance;
  }

  public void putParameters(long arrayId, SimpleArrayStatistic statistic) {
    if (statistic == null) {
      logger.warn("Statistic is null in array with id = {}", arrayId);
    }
    parameters.put(arrayId, statistic);
  }

  public Optional<SimpleArrayStatistic> getParameters(long arrayId) {
    Optional<SimpleArrayStatistic> optionalParameters = Optional.ofNullable(parameters.get(arrayId));
    if (optionalParameters.isEmpty()) {
      logger.warn("No such array with id = {}", arrayId);
    }
    return optionalParameters;
  }
}
