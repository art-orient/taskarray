package by.art.taskarray.specification.id;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.specification.Specification;

public record IdEqualsSpecification(long id) implements Specification {

  @Override
  public boolean specify(SimpleArray simpleArray) {
    return id == simpleArray.getArrayId();
  }
}
