package by.art.taskarray.comparator;

import by.art.taskarray.entity.SimpleArray;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValueEnumComparatorTest {

  @Test
  @Tag("comparator")
  void compareByIdShouldReturnNegativeWhenFirstIdIsSmaller() {
    SimpleArray array1 = createSimpleArray(1, 1, 2, 3);
    SimpleArray array2 = createSimpleArray(5, 1, 2, 3);
    int actual = ArrayValueEnumComparator.ID.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareByIdShouldReturnZeroWhenIdsAreEqual() {
    SimpleArray array1 = createSimpleArray(10, 1, 2);
    SimpleArray array2 = createSimpleArray(10, 5, 6);
    int actual = ArrayValueEnumComparator.ID.compare(array1, array2);
    assertEquals(0, actual);
  }

  @Test
  @Tag("comparator")
  void compareByIdShouldReturnPositiveWhenFirstIdIsGreater() {
    SimpleArray array1 = createSimpleArray(20, 1);
    SimpleArray array2 = createSimpleArray(5, 1);
    int actual = ArrayValueEnumComparator.ID.compare(array1, array2);
    assertTrue(actual > 0);
  }

  @Test
  @Tag("comparator")
  void compareByMinShouldReturnCorrectOrder() {
    SimpleArray array1 = createSimpleArray(1, 5, 10, -3);
    SimpleArray array2 = createSimpleArray(2, 2, 3, 4);
    int actual = ArrayValueEnumComparator.MIN.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareByMaxShouldReturnCorrectOrder() {
    SimpleArray array1 = createSimpleArray(1, 1, 2, 3);
    SimpleArray array2 = createSimpleArray(2, 10, 20, 30);
    int actual = ArrayValueEnumComparator.MAX.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareBySumShouldReturnCorrectOrder() {
    SimpleArray array1 = createSimpleArray(1, 1, 1, 1);
    SimpleArray array2 = createSimpleArray(2, 5, 5);
    int actual = ArrayValueEnumComparator.SUM.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareByFirstShouldReturnCorrectOrder() {
    SimpleArray array1 = createSimpleArray(1, 1, 2, 3);
    SimpleArray array2 = createSimpleArray(2, 5, 6, 7);
    int actual = ArrayValueEnumComparator.FIRST.compare(array1, array2);
    assertTrue(actual < 0);
  }

  @Test
  @Tag("comparator")
  void compareByFirstShouldReturnPositiveWhenFirstElementIsGreater() {
    SimpleArray array1 = createSimpleArray(1, 10, 2);
    SimpleArray array2 = createSimpleArray(2, 1, 2);
    int actual = ArrayValueEnumComparator.FIRST.compare(array1, array2);
    assertTrue(actual > 0);
  }

  @Test
  @Tag("comparator")
  void compareByFirstShouldReturnZeroWhenFirstElementsAreEqual() {
    SimpleArray array1 = createSimpleArray(1, 7, 2, 3);
    SimpleArray array2 = createSimpleArray(2, 7, 9, 10);
    int actual = ArrayValueEnumComparator.FIRST.compare(array1, array2);
    assertEquals(0, actual);
  }

  private SimpleArray createSimpleArray(long id, long... values) {
    return new SimpleArray(id, values);
  }
}