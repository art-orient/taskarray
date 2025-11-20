package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;

import java.util.stream.LongStream;

public class ContainsNumberSpecificationPredicate implements SpecificationPredicate {

  private final long value;

  public ContainsNumberSpecificationPredicate(long value) {
    this.value = value;
  }

  @Override
  public boolean test(SimpleArray simpleArray) {
    long[] array = simpleArray.getArray();
    return LongStream.of(array).allMatch(v -> v == value);
  }
}
