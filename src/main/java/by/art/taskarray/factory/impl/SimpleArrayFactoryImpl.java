package by.art.taskarray.factory.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.factory.SimpleArrayFactory;
import by.art.taskarray.observer.SimpleArrayObserver;
import by.art.taskarray.observer.impl.SimpleArrayObserverImpl;
import by.art.taskarray.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class SimpleArrayFactoryImpl implements SimpleArrayFactory {

  public static final Logger logger = LogManager.getLogger();

  @Override
  public SimpleArray createSimpleArray(long[] array) {
    long simpleArrayId = IdGenerator.generateId();
    SimpleArray simpleArray = new SimpleArray(simpleArrayId, array);
    SimpleArrayObserver observer = new SimpleArrayObserverImpl();
    simpleArray.attach(observer);
    logger.debug("SimpleArray with ID = {} was created", simpleArrayId);
    return simpleArray;
  }

  @Override
  public List<SimpleArray> createSimpleArrays(List<long[]> arrays) {
    List<SimpleArray> simpleArrays = new ArrayList<>();
    for (long[] array : arrays) {
      SimpleArray simpleArray = createSimpleArray(array);
      simpleArrays.add(simpleArray);
    }
    logger.debug("SimpleArrays were created");
    return simpleArrays;
  }
}
