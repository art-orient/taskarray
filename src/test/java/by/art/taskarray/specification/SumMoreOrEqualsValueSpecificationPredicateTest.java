package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumMoreOrEqualsValueSpecificationPredicateTest {

  @Test
  @Tag("specification")
  void testSumGreaterThanValueShouldReturnTrue() {
    SimpleArray array = new SimpleArray(1, new long[]{5, 10, 15});
    SumMoreOrEqualsValueSpecificationPredicate predicate = new SumMoreOrEqualsValueSpecificationPredicate(20);
    assertTrue(predicate.test(array));
  }

  @Test
  @Tag("specification")
  void testSumEqualsValueShouldReturnTrue() {
    SimpleArray array = new SimpleArray(2, new long[]{5, 10, 15});
    SumMoreOrEqualsValueSpecificationPredicate predicate = new SumMoreOrEqualsValueSpecificationPredicate(30);
    assertTrue(predicate.test(array));
  }

  @Test
  @Tag("specification")
  void testSumLessThanValueShouldReturnFalse() {
    SimpleArray array = new SimpleArray(3, new long[]{5, 10});
    SumMoreOrEqualsValueSpecificationPredicate predicate = new SumMoreOrEqualsValueSpecificationPredicate(20);
    assertFalse(predicate.test(array));
  }

  @Test
  @Tag("specification")
  void testEmptyArrayShouldReturnFalse() {
    SimpleArray array = new SimpleArray(4, new long[]{});
    SumMoreOrEqualsValueSpecificationPredicate predicate = new SumMoreOrEqualsValueSpecificationPredicate(0);
    assertFalse(predicate.test(array));
  }
}