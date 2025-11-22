package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;

import java.util.stream.LongStream;

public record ContainsNumberSpecificationPredicate(long value) implements SpecificationPredicate {

  @Override
  public boolean test(SimpleArray simpleArray) {
    long[] array = simpleArray.getArray();
    return LongStream.of(array).anyMatch(v -> v == value);
  }
}
