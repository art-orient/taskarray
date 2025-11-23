package by.art.taskarray.specification.sum;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.ArrayValueService;
import by.art.taskarray.service.impl.ArrayValueServiceImpl;
import by.art.taskarray.specification.SpecificationPredicate;

public record SumMoreOrEqualsValueSpecificationPredicate(long value) implements SpecificationPredicate {

  @Override
  public boolean test(SimpleArray simpleArray) {
    ArrayValueService service = new ArrayValueServiceImpl();
    long sum = service.sum(simpleArray).orElse(Long.MIN_VALUE);
    return value <= sum;
  }
}
