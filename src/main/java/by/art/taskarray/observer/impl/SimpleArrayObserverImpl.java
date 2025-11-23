package by.art.taskarray.observer.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.observer.SimpleArrayEvent;
import by.art.taskarray.observer.SimpleArrayObserver;
import by.art.taskarray.entity.SimpleArrayStatistic;
import by.art.taskarray.service.ArrayValueService;
import by.art.taskarray.service.impl.ArrayValueServiceImpl;
import by.art.taskarray.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleArrayObserverImpl implements SimpleArrayObserver {
  private static final Logger logger = LogManager.getLogger();

  @Override
  public void update(SimpleArrayEvent simpleArrayEvent) {
    ArrayValueService service = new ArrayValueServiceImpl();
    SimpleArray simpleArray = simpleArrayEvent.getSource();
    long min = service.min(simpleArray).orElse(Long.MAX_VALUE);
    long max = service.max(simpleArray).orElse(Long.MIN_VALUE);
    long sum = service.sum(simpleArray).orElse(0L);
    SimpleArrayStatistic statistic = new SimpleArrayStatistic(min, max, sum);
    Warehouse warehouse = Warehouse.getInstance();
    warehouse.put(simpleArray.getArrayId(), statistic);
    logger.info("Added parameters into warehouse, array ID = {}", simpleArray.getArrayId());
  }
}
