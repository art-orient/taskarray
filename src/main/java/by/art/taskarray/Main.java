package by.art.taskarray;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.exception.SimpleArrayException;
import by.art.taskarray.factory.SimpleArrayFactory;
import by.art.taskarray.factory.impl.SimpleArrayFactoryImpl;
import by.art.taskarray.parser.LongNumberParser;
import by.art.taskarray.parser.impl.LongNumberParserImpl;
import by.art.taskarray.reader.DataReader;
import by.art.taskarray.reader.impl.DataReaderImpl;
import by.art.taskarray.service.ArraySortService;
import by.art.taskarray.service.ArrayValueService;
import by.art.taskarray.service.impl.ArraySortServiceImpl;
import by.art.taskarray.service.impl.ArrayValueServiceImpl;

import java.util.List;

public class Main {
  public static void main(String[] args) throws SimpleArrayException {
    DataReader reader = new DataReaderImpl();
    List<String> linesFromFile = reader.readFile("data/data.txt");
    LongNumberParser parser = new LongNumberParserImpl();
    List<long[]> longArrays = parser.parseNumberLine(linesFromFile);
    SimpleArrayFactory factory = new SimpleArrayFactoryImpl();
    List <SimpleArray> simpleArrays = factory.createSimpleArrays(longArrays);
    ArrayValueService arrayValueService = new ArrayValueServiceImpl();
    for (SimpleArray simpleArray : simpleArrays) {
      arrayValueService.min(simpleArray);
      arrayValueService.max(simpleArray);
      arrayValueService.sum(simpleArray);
    }
    ArraySortService sortService = new ArraySortServiceImpl();
    sortService.bubbleSort(simpleArrays.get(2));
    sortService.insertionSort(simpleArrays.get(3));

  }
}
