package by.art.taskarray;

import by.art.taskarray.exception.SimpleArrayException;
import by.art.taskarray.parser.LongNumberParser;
import by.art.taskarray.parser.impl.LongNumberParserImpl;
import by.art.taskarray.reader.DataReader;
import by.art.taskarray.reader.impl.DataReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static final Logger logger = LogManager.getLogger();

  public static void main(String[] args) {
    DataReader reader = new DataReaderImpl();
    List<String> linesFromFile = new ArrayList<>();
    try {
      linesFromFile = reader.readFile("data/data.txt");
    } catch (SimpleArrayException e) {
      logger.warn(e.getMessage());
    }
    LongNumberParser parser = new LongNumberParserImpl();
    List<long[]> longArrays = parser.parseNumberLine(linesFromFile);
  }
}
