package by.art.taskarray.reader.impl;

import by.art.taskarray.exception.SimpleArrayException;
import by.art.taskarray.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataReaderImpl implements DataReader {
  private static final Logger logger = LogManager.getLogger();

  @Override
  public List<String> readFile (String filePath) throws SimpleArrayException {
    List<String> lines;
    Path path = Paths.get(filePath);
    try {
      lines = Files.readAllLines(path);
      logger.info("File {} was read successfully", filePath);
    } catch (IOException e) {
      logger.error("Failed to read file {}", filePath);
      throw new SimpleArrayException(String.format("Failed to read file %s", filePath), e);
    }
    return lines;
  }
}
