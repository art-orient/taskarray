package by.art.taskarray.comparator;

import by.art.taskarray.entity.SimpleArray;

import java.util.Comparator;

public class IdComparator implements Comparator<SimpleArray> {

  @Override
  public int compare(SimpleArray simpleArray1, SimpleArray simpleArray2) {
    return Long.compare(simpleArray1.getArrayId(),simpleArray2.getArrayId());
  }
}
