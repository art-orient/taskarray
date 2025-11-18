package by.art.taskarray.reader.impl;

import by.art.taskarray.exception.SimpleArrayException;
import by.art.taskarray.reader.DataReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderImplTest {
  DataReader reader;

  @BeforeEach
  void setUp() {
    reader = new DataReaderImpl();
  }

  @AfterEach
  void tearDown() {
    reader = null;
  }

  @Test
  void readFileSuccessfullyTest() throws SimpleArrayException {
    List<String> expected = Arrays.asList("1; 2;    3",
            "1; 2; x3; 6..5; 77",
            "",
            "11, -2,,,8",
            "one, two, three",
            "    42; 21;    5; 10; 100",
            "68425862; 5843; -876221563; 85462;2254; 8562",
            "10.5; 54; 6.2");
    List<String> actual = reader.readFile("data/data.txt");
    assertIterableEquals(expected, actual);
  }

  @Test()
  void readNoExistFileThenThrowExceptionTest() {
    SimpleArrayException exception = assertThrows(SimpleArrayException.class,
            () -> reader.readFile("data/no_file.txt"));
    assertTrue(exception.getMessage().contains("Failed to read file"));
  }
}