package by.art.taskarray.factory;

import by.art.taskarray.entity.SimpleArray;

import java.util.List;

public interface SimpleArrayFactory {
  SimpleArray createSimpleArray (long[] array);

  List<SimpleArray> createSimpleArrays (List<long[]> arrays);
}
