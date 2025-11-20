package by.art.taskarray.comparator;

import by.art.taskarray.entity.SimpleArray;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumArrayComparatorTest {

  @Test
  @Tag("comparator")
  void compareById_shouldReturnNegative_whenFirstIdIsSmaller() {
    SimpleArray array1 = createSimpleArray(1, 1, 2, 3);
    SimpleArray array2 = createSimpleArray(5, 1, 2, 3);
    int actual = EnumArrayComparator.ID.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareById_shouldReturnZero_whenIdsAreEqual() {
    SimpleArray array1 = createSimpleArray(10, 1, 2);
    SimpleArray array2 = createSimpleArray(10, 5, 6);
    int actual = EnumArrayComparator.ID.compare(array1, array2);
    assertEquals(0, actual);
  }

  @Test
  @Tag("comparator")
  void compareById_shouldReturnPositive_whenFirstIdIsGreater() {
    SimpleArray array1 = createSimpleArray(20, 1);
    SimpleArray array2 = createSimpleArray(5, 1);
    int actual = EnumArrayComparator.ID.compare(array1, array2);
    assertTrue(actual > 0);
  }

  @Test
  @Tag("comparator")
  void compareByMin_shouldReturnCorrectOrder() {
    SimpleArray array1 = createSimpleArray(1, 5, 10, -3);
    SimpleArray array2 = createSimpleArray(2, 2, 3, 4);
    int actual = EnumArrayComparator.MIN.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareByMax_shouldReturnCorrectOrder() {
    SimpleArray array1 = createSimpleArray(1, 1, 2, 3);
    SimpleArray array2 = createSimpleArray(2, 10, 20, 30);
    int actual = EnumArrayComparator.MAX.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareBySum_shouldReturnCorrectOrder() {
    SimpleArray array1 = createSimpleArray(1, 1, 1, 1);
    SimpleArray array2 = createSimpleArray(2, 5, 5);
    int actual = EnumArrayComparator.SUM.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareByFirst_shouldReturnCorrectOrder() {
    SimpleArray array1 = createSimpleArray(1, 1, 2, 3);
    SimpleArray array2 = createSimpleArray(2, 5, 6, 7);
    int actual = EnumArrayComparator.FIRST.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareByFirst_shouldReturnPositive_whenFirstElementIsGreater() {
    SimpleArray array1 = createSimpleArray(1, 10, 2);
    SimpleArray array2 = createSimpleArray(2, 1, 2);
    int actual = EnumArrayComparator.FIRST.compare(array1, array2);
    assertTrue(actual > 0);
  }

  @Test
  @Tag("comparator")
  void compareByFirst_shouldReturnZero_whenFirstElementsAreEqual() {
    SimpleArray array1 = createSimpleArray(1, 7, 2, 3);
    SimpleArray array2 = createSimpleArray(2, 7, 9, 10);
    int actual = EnumArrayComparator.FIRST.compare(array1, array2);
    assertEquals(0, actual);
  }

  private SimpleArray createSimpleArray(long id, long... values) {
    return new SimpleArray(id, values);
  }
}