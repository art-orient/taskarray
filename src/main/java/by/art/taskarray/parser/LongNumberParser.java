package by.art.taskarray.parser;

import java.util.List;

public interface LongNumberParser {
  String SEPARATOR_REGEX = "[,;\\s]+";
  List<long[]> parseNumberLine(List<String> numberLines);
}
