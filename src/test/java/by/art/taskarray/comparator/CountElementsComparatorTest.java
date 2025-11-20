package by.art.taskarray.comparator;

import by.art.taskarray.entity.SimpleArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CountElementsComparatorTest {
  private final Comparator<SimpleArray> comparator = new CountElementsComparator();

  @Test
  @Tag("comparator")
  void compare_shouldReturnZero_whenArraysHaveSameSize() {
    SimpleArray a1 = new SimpleArray(new long[]{1, 2, 3});
    SimpleArray a2 = new SimpleArray(new long[]{10, 20, 30});
    int actual = comparator.compare(a1, a2);
    assertEquals(0, actual, "Comparator must return 0 for arrays with equal length");
  }

  @Test
  @Tag("comparator")
  void compare_shouldReturnNegative_whenFirstArrayHasFewerElements() {
    SimpleArray a1 = new SimpleArray(new long[]{1, 2});
    SimpleArray a2 = new SimpleArray(new long[]{10, 20, 30});
    int actual = comparator.compare(a1, a2);
    assertTrue(actual < 0, "Comparator must return negative if first array is smaller");
  }

  @Test
  @Tag("comparator")
  void compare_shouldReturnPositive_whenFirstArrayHasMoreElements() {
    SimpleArray a1 = new SimpleArray(new long[]{1, 2, 3, 4});
    SimpleArray a2 = new SimpleArray(new long[]{10, 20});
    int actual = comparator.compare(a1, a2);
    assertTrue(actual > 0, "Comparator must return positive if first array is bigger");
  }

  @Test
  @Tag("comparator")
  void compare_shouldHandleEmptyArrays() {
    SimpleArray a1 = new SimpleArray(new long[]{});
    SimpleArray a2 = new SimpleArray(new long[]{1});
    int actual = comparator.compare(a1, a2);
    assertTrue(actual < 0, "Empty array must be considered smaller");
  }
}