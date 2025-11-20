package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.ArrayValueService;
import by.art.taskarray.service.impl.ArrayValueServiceImpl;

public class SumMoreOrEqualsValueSpecificationPredicate implements SpecificationPredicate {

  private final long value;

  public SumMoreOrEqualsValueSpecificationPredicate(long value) {
    this.value = value;
  }

  @Override
  public boolean test(SimpleArray simpleArray) {
    ArrayValueService service = new ArrayValueServiceImpl();
    long sum = service.sum(simpleArray).getAsLong();
    return value <= sum;
  }
}
