package by.art.taskarray.factory.impl;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.exception.SimpleArrayException;
import by.art.taskarray.factory.SimpleArrayFactory;
import by.art.taskarray.parser.LongNumberParser;
import by.art.taskarray.parser.impl.LongNumberParserImpl;
import by.art.taskarray.reader.DataReader;
import by.art.taskarray.reader.impl.DataReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SimpleArrayFactoryImpl implements SimpleArrayFactory {
  private static int counterId = 1;
  public static final Logger logger = LogManager.getLogger();
  DataReader reader = new DataReaderImpl();
  LongNumberParser parser = new LongNumberParserImpl();

  @Override
  public List<SimpleArray> createSimpleArray(String filePath) {
    List<String> linesFromFile = extractDataFromFile(filePath);
    List<long[]> longArrays = parser.parseNumberLine(linesFromFile);
    List<SimpleArray> simpleArrays = new ArrayList<>();
    for (long[] array : longArrays) {
      long simpleArrayId = createId();
      SimpleArray simpleArray = new SimpleArray(simpleArrayId, array);
      simpleArrays.add(simpleArray);
    }
    return simpleArrays;
  }

  private List<String> extractDataFromFile(String filePath) {
    List<String> linesFromFile = new ArrayList<>();
    try {
      linesFromFile = reader.readFile(filePath);
    } catch (SimpleArrayException e) {
      logger.warn(e.getMessage());
    }
    return linesFromFile;
  }

  private static long createId() {
    return counterId++;
  }
}
