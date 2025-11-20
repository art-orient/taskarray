package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;

import java.util.function.Predicate;

@FunctionalInterface
public interface SpecificationPredicate extends Predicate<SimpleArray> {
  boolean test(SimpleArray simpleArray);
}
