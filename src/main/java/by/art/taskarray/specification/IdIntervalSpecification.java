package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;

public record IdIntervalSpecification(long minId, long maxId) implements Specification {

  @Override
  public boolean specify(SimpleArray simpleArray) {
    return (minId <= simpleArray.getArrayId() && simpleArray.getArrayId() <= maxId);
  }
}
