package by.art.taskarray.reader;

import by.art.taskarray.exception.SimpleArrayException;

import java.util.List;

public interface DataReader {
  List<String> readFile (String path) throws SimpleArrayException;
}
