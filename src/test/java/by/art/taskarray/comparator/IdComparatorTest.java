package by.art.taskarray.comparator;

import by.art.taskarray.entity.SimpleArray;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdComparatorTest {
  private final IdComparator comparator = new IdComparator();

  @Test
  @Tag("comparator")
  void compareShouldReturnZeroWhenIdsAreEqual() {
    SimpleArray array1 = createSimpleArray(10, 1, 2, 3);
    SimpleArray array2 = createSimpleArray(10, 4, 5, 6);
    int actual = comparator.compare(array1, array2);
    assertEquals(0, actual);
  }

  @Test
  @Tag("comparator")
  void compareShouldReturnNegativeWhenFirstIdIsSmaller() {
    SimpleArray array1 = createSimpleArray(1, 1, 2, 3);
    SimpleArray array2 = createSimpleArray(5, 4, 5, 6);
    int actual = comparator.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareShouldReturnPositiveWhenFirstIdIsGreater() {
    SimpleArray array1 = createSimpleArray(20, 1, 2, 3);
    SimpleArray array2 = createSimpleArray(5, 4, 5, 6);
    int actual = comparator.compare(array1, array2);
    assertTrue(actual > 0);
  }

  private SimpleArray createSimpleArray(long id, long... values) {
    return new SimpleArray(id, values);
  }
}