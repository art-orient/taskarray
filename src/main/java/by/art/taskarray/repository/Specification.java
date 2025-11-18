package by.art.taskarray.repository;

import by.art.taskarray.entity.SimpleArray;

@FunctionalInterface
public interface Specification {
  boolean specify(SimpleArray simpleArray);
}
