package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdSpecificationPredicateTest {

  @Test
  @Tag("specification")
  void testIdMatchesShouldReturnTrue() {
    SimpleArray array = new SimpleArray(5, new long[]{1, 2, 3});
    IdSpecificationPredicate predicate = new IdSpecificationPredicate(5);
    assertTrue(predicate.test(array));
  }

  @Test
  @Tag("specification")
  void testIdDoesNotMatch_shouldReturnFalse() {
    SimpleArray array = new SimpleArray(10, new long[]{1, 2, 3});
    IdSpecificationPredicate predicate = new IdSpecificationPredicate(5);
    assertFalse(predicate.test(array));
  }
}