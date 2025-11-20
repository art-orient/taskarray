package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;

public class IdSpecification implements Specification {

  private int id;

  public IdSpecification(int id) {
    this.id = id;
  }

  @Override
  public boolean specify(SimpleArray simpleArray) {
    return id == simpleArray.getArrayId();
  }
}
