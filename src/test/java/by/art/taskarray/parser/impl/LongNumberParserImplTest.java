package by.art.taskarray.parser.impl;

import by.art.taskarray.parser.LongNumberParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongNumberParserImplTest {
  List<String> dataFromFile;

  @BeforeEach
  void setUp() {
    dataFromFile = Arrays.asList("1; 2;    3",
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
    dataFromFile = null;
  }

  @Test
  void parseNumberLine() {
    LongNumberParser parser = new LongNumberParserImpl();
    List<long[]> expected = new ArrayList<>();
    expected.add(new long[]{1, 2, 3});
    expected.add(new long[]{11, -2, 8});
    expected.add(new long[]{42, 21, 5, 10, 100});
    expected.add(new long[]{68425862, 5843, -876221563, 85462, 2254, 8562});

    List<long[]> actual = parser.parseNumberLine(dataFromFile);
    assertEquals(expected.size(), actual.size());
    assertArrayEquals(expected.get(0), actual.get(0));
    assertArrayEquals(expected.get(1), actual.get(1));
    assertArrayEquals(expected.get(2), actual.get(2));
    assertArrayEquals(expected.get(3), actual.get(3));
  }
}