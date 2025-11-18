package by.art.taskarray.repository;

import by.art.taskarray.entity.SimpleArray;

public class IdIntervalSpecification implements Specification {

  private final int minId;
  private final int maxId;

  public IdIntervalSpecification(int minId, int maxId) {
    this.minId = minId;
    this.maxId = maxId;
  }

  @Override
  public boolean specify(SimpleArray simpleArray) {
    return (minId <= simpleArray.getArrayId() && simpleArray.getArrayId() <= maxId);
  }
}
