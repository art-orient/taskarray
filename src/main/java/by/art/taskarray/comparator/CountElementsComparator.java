package by.art.taskarray.comparator;

import by.art.taskarray.entity.SimpleArray;
import java.util.Comparator;
import java.util.stream.LongStream;

public class CountElementsComparator implements Comparator<SimpleArray> {

  @Override
  public int compare(SimpleArray simpleArray1, SimpleArray simpleArray2) {
    long count1 = LongStream.of(simpleArray1.getArray()).summaryStatistics().getCount();
    long count2 = LongStream.of(simpleArray2.getArray()).summaryStatistics().getCount();
    return Long.compare(count1, count2);
  }
}
