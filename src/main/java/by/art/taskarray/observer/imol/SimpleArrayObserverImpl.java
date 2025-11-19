package by.art.taskarray.observer.imol;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.observer.SimpleArrayEvent;
import by.art.taskarray.observer.SimpleArrayObserver;
import by.art.taskarray.statistic.SimpleArrayStatistic;
import by.art.taskarray.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LongSummaryStatistics;

public class SimpleArrayObserverImpl implements SimpleArrayObserver {
  private static final Logger logger = LogManager.getLogger();

  @Override
  public void update(SimpleArrayEvent simpleArrayEvent) {
    SimpleArray simpleArray = simpleArrayEvent.getSource();
    long[] array = simpleArray.getArray();
    LongSummaryStatistics summaryStatistics = Arrays.stream(array).summaryStatistics();
    long min = summaryStatistics.getMin();
    long max = summaryStatistics.getMax();
    long sum = summaryStatistics.getSum();
    SimpleArrayStatistic statistic = new SimpleArrayStatistic(min, max, sum);
    Warehouse warehouse = Warehouse.getInstance();
    warehouse.putParameters(simpleArray.getArrayId(), statistic);
    logger.info("Added parameters into warehouse, array ID = {}", simpleArray.getArrayId());
  }
}
