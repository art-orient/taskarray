package by.art.taskarray.parser.impl;

import by.art.taskarray.parser.LongNumberParser;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongNumberParserImplTest {
  private final LongNumberParser parser = new LongNumberParserImpl();

  @Test
  @Tag("parser")
  void parseValidLines() {
    List<String> lines = Arrays.asList("1; 2;    3",
            "1; 2; x3; 6..5; 77",
            "11, -2,,,8",
            "    42; 21;    5; 10; 100",
            "68425862; 5843; -876221563; 85462;2254; 8562");
    List<long[]> actual = parser.parseNumberLine(lines);
    assertAll (
            () -> assertEquals(4, actual.size()),
            () -> assertArrayEquals(new long[]{1, 2, 3}, actual.get(0)),
            () -> assertArrayEquals(new long[]{11, -2, 8}, actual.get(1)),
            () -> assertArrayEquals(new long[]{42, 21, 5, 10, 100}, actual.get(2)),
            () -> assertArrayEquals(new long[]{68425862, 5843, -876221563, 85462, 2254, 8562}, actual.get(3))
    );
  }

  @Test
  @Tag("parser")
  void ignoreInvalidLines() {
    List<String> lines = List.of(
            "1 2 3",
            "abc def",
            "1 x 3",
            "",
            "   ",
            "10 20");
    List<long[]> actual = parser.parseNumberLine(lines);
    assertAll (
            () -> assertEquals(2, actual.size()),
            () -> assertArrayEquals(new long[]{1, 2, 3}, actual.get(0)),
            () -> assertArrayEquals(new long[]{10, 20}, actual.get(1))
    );
  }

  @Test
  @Tag("parser")
  void onlyInvalidLines() {
    List<String> lines = List.of(
            "",
            "   ",
            "hello world",
            "x y z"
    );
    List<long[]> actual = parser.parseNumberLine(lines);
    assertTrue(actual.isEmpty());
  }

  @Test
  @Tag("parser")
  void parseLongValues() {
    List<String> lines = List.of("9223372036854775807 -9223372036854775808");
    List<long[]> actual = parser.parseNumberLine(lines);
    assertAll (
            () -> assertEquals(1, actual.size()),
            () -> assertArrayEquals(new long[]{Long.MAX_VALUE, Long.MIN_VALUE}, actual.get(0))
    );
  }

  @Test
  @Tag("parser")
  void trimSpaces() {
    List<String> lines = List.of(
            "   1   2   3   ",
            "   10 20 30",
            "5   ");
    List<long[]> actual = parser.parseNumberLine(lines);
    assertAll (
            () -> assertEquals(3, actual.size()),
            () -> assertArrayEquals(new long[]{1, 2, 3}, actual.get(0)),
            () -> assertArrayEquals(new long[]{10, 20, 30}, actual.get(1)),
            () -> assertArrayEquals(new long[]{5}, actual.get(2))
    );
  }
}