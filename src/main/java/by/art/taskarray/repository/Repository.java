package by.art.taskarray.repository;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.exception.SimpleArrayException;
import by.art.taskarray.specification.Specification;
import by.art.taskarray.specification.SpecificationPredicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Repository {
  public static final Logger logger = LogManager.getLogger();
  private static Repository instance;
  private final List<SimpleArray> simpleArrays = new ArrayList<>();

  private Repository() {
  }

  public static Repository getInstance() {
    if (instance == null) {
      instance = new Repository();
    }
    return instance;
  }

  public void add(SimpleArray simpleArray) throws SimpleArrayException {
    if (simpleArray == null) {
      logger.warn("SimpleArray is null during adding to repository");
      throw new SimpleArrayException("SimpleArray is null during adding to repository");
    }
    simpleArrays.add(simpleArray);
    logger.debug("SimpleArray with ID = {} added to repository", simpleArray.getArrayId());
  }

  public void add(List<SimpleArray> simpleArraysToAdd) throws SimpleArrayException {
    if (simpleArraysToAdd == null) {
      logger.warn("List of SimpleArrays is null during adding to repository");
      throw new SimpleArrayException("List of SimpleArrays is null during adding to repository");
    }
    simpleArrays.addAll(simpleArraysToAdd);
    logger.debug("SimpleArrays were added to repository");
  }

  public void remove(SimpleArray simpleArray) throws SimpleArrayException {
    if (simpleArray == null) {
      logger.warn("SimpleArray is null during deleting from repository");
      throw new SimpleArrayException("SimpleArray is null during deleting from repository");
    }
    simpleArrays.remove(simpleArray);
    logger.debug("SimpleArrays removed from repository");
  }

  public void remove(int index) throws SimpleArrayException {
    if (index < 0) {
      logger.warn("Wrong index = {}", index);
      throw new SimpleArrayException(String.format("Wrong index = %d", index));
    }
    simpleArrays.remove(index);
    logger.debug("SimpleArray with index = {} removed from repository", index);
  }

  public List<SimpleArray> sort(Comparator<? super SimpleArray> comparator) {
    logger.debug("Sorting of repository by comparator");
    return simpleArrays.stream()
            .sorted(comparator)
            .toList();
  }

  public List<SimpleArray> query(Specification specification) {
    List<SimpleArray> result = new ArrayList<>();
    for (SimpleArray simpleArray : simpleArrays) {
      if (specification.specify(simpleArray)) {
        result.add(simpleArray);
      }
    }
    return result;
  }

  public List<SimpleArray> queryStream(Specification specification) {
    return simpleArrays.stream()
            .filter(specification::specify)
            .toList();
  }

  public List<SimpleArray> queryStreamPredicate(SpecificationPredicate specification) {
    return simpleArrays.stream()
            .filter(specification)
            .toList();
  }
}
