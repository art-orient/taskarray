package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;

@FunctionalInterface
public interface Specification {
  boolean specify(SimpleArray simpleArray);
}
