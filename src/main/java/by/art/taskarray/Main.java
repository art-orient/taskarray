package by.art.taskarray;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.factory.SimpleArrayFactory;
import by.art.taskarray.factory.impl.SimpleArrayFactoryImpl;
import by.art.taskarray.service.ArrayValueService;
import by.art.taskarray.service.impl.ArrayValueServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    SimpleArrayFactory factory = new SimpleArrayFactoryImpl();
    List <SimpleArray> simpleArrays = factory.createSimpleArray("data/data.txt");
    ArrayValueService arrayValueService = new ArrayValueServiceImpl();
    for (SimpleArray simpleArray : simpleArrays) {
      System.out.println(Arrays.toString(simpleArray.getArray()));
      arrayValueService.min(simpleArray);
      arrayValueService.max(simpleArray);
      arrayValueService.sum(simpleArray);
    }
  }
}
