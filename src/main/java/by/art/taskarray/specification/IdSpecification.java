package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;

public record IdSpecification(long id) implements Specification {

  @Override
  public boolean specify(SimpleArray simpleArray) {
    return id == simpleArray.getArrayId();
  }
}
