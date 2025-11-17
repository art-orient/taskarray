package by.art.taskarray.factory;

import by.art.taskarray.entity.SimpleArray;

import java.util.List;

public interface SimpleArrayFactory {
  List<SimpleArray> createSimpleArray (List<long[]> longArrays);
}
