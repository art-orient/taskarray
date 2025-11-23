package by.art.taskarray.specification.id;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.specification.Specification;

public record IdIntervalSpecification(long minId, long maxId) implements Specification {

  @Override
  public boolean specify(SimpleArray simpleArray) {
    return (minId <= simpleArray.getArrayId() && simpleArray.getArrayId() <= maxId);
  }
}
