package by.art.taskarray.repository;

import by.art.taskarray.entity.SimpleArray;

import java.util.ArrayList;
import java.util.List;

public class Repository {
  private static Repository instance;
  private final List<SimpleArray> simpleArrays = new ArrayList<>();

  public Repository() {
  }

  public static Repository getInstance() {
    if (instance == null) {
      instance = new Repository();
    }
    return instance;
  }

  public void addSimpleArray(SimpleArray simpleArray) {
    simpleArrays.add(simpleArray); // клоны???
  }

  public List<SimpleArray> getSimpleArrays() {
    return simpleArrays; // клоны???
  }
}
