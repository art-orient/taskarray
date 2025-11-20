package by.art.taskarray.reader.impl;

import by.art.taskarray.exception.SimpleArrayException;
import by.art.taskarray.reader.DataReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderImplTest {
  DataReader reader;
  List<String> expected;

  @BeforeEach
  void setUp() {
    reader = new DataReaderImpl();
    expected = Arrays.asList("1; 2;    3",
            "1; 2; x3; 6..5; 77",
            "",
            "11, -2,,,8",
            "one, two, three",
            "    42; 21;    5; 10; 100",
            "68425862; 5843; -876221563; 85462;2254; 8562",
            "10.5; 54; 6.2");
  }

  @AfterEach
  void tearDown() {
    reader = null;
    expected = null;
  }

  @Test
  void readFileWithMock_ShouldReturnLines_whenFileReadSuccessfully() throws SimpleArrayException {
    String filepath = "test_data.txt";
    Path path = Path.of(filepath);
    try (var mocked = Mockito.mockStatic(Files.class)) {
      mocked.when(() -> Files.readAllLines(path)).thenReturn(expected);
      List<String> actual = reader.readFile(filepath);
      assertEquals(8, actual.size());
      assertEquals("1; 2;    3", actual.get(0));
      assertEquals("1; 2; x3; 6..5; 77", actual.get(1));
      mocked.verify(() -> Files.readAllLines(path));
    }
  }

  @Test()
  void readNoExistFile_shouldThrowException_whenExceptionOccurs() {
    String badPath = "data/no_file.txt";
    SimpleArrayException exception = assertThrows(SimpleArrayException.class,
            () -> reader.readFile(badPath));
    boolean isMessageContainsFileNotRead = exception.getMessage().contains("Failed to read file");
    assertTrue(isMessageContainsFileNotRead);
  }

  @Test()
  void readNoExistFileWithMock_shouldThrowException_whenExceptionOccurs() {
    String badFilePath = "data/no_file.txt";
    Path path = Path.of(badFilePath);
    try (var mocked = Mockito.mockStatic(Files.class)) {
      mocked.when(() -> Files.readAllLines(path))
              .thenThrow(new IOException(String.format("Failed to read file %s", badFilePath)));
      SimpleArrayException exception = assertThrows(SimpleArrayException.class,
              () -> reader.readFile(badFilePath));
      boolean isMessageContainsFileNotRead = exception.getMessage().contains("Failed to read file");
      assertTrue(isMessageContainsFileNotRead);
      mocked.verify(() -> Files.readAllLines(path));
    }
  }

  @Test
  void readFile_shouldReadRealFileFromResourcesSuccessfully() throws Exception {
    String filepath = "test_data.txt";
    ClassLoader classLoader = getClass().getClassLoader();
    URL resourceUrl = classLoader.getResource(filepath);
    assertNotNull(resourceUrl, "file not found");
    Path path = Path.of(resourceUrl.toURI());
    System.out.println(path);
    List<String> actual = reader.readFile(path.toString());
    assertIterableEquals(expected, actual);
    assertEquals(8, actual.size());
    assertEquals("1; 2;    3", actual.get(0));
    assertEquals("1; 2; x3; 6..5; 77", actual.get(1));
  }
}