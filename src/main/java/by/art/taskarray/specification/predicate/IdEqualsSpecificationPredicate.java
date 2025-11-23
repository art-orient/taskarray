package by.art.taskarray.specification.predicate;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.specification.SpecificationPredicate;

public record IdEqualsSpecificationPredicate(long id) implements SpecificationPredicate {

  @Override
  public boolean test(SimpleArray simpleArray) {
    return id == simpleArray.getArrayId();
  }
}
