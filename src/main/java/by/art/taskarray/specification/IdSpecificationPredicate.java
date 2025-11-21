package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;

public record IdSpecificationPredicate(long id) implements SpecificationPredicate {

  @Override
  public boolean test(SimpleArray simpleArray) {
    return id == simpleArray.getArrayId();
  }
}
