package by.art.taskarray.repository;

import by.art.taskarray.entity.SimpleArray;

public class IdSpecificationPredicate implements SpecificationPredicate {

  private int id;

  public IdSpecificationPredicate(int id) {
    this.id = id;
  }

  @Override
  public boolean test(SimpleArray simpleArray) {
    return id == simpleArray.getArrayId();
  }
}
