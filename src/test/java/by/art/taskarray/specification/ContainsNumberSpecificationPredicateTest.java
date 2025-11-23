package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.specification.predicate.ContainsNumberSpecificationPredicate;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsNumberSpecificationPredicateTest {

  @Test
  @Tag("specification")
  void testElementMatchShouldReturnTrue() {
    SimpleArray array = new SimpleArray(1, new long[]{1, 5, 9});
    ContainsNumberSpecificationPredicate predicate = new ContainsNumberSpecificationPredicate(5);
    assertTrue(predicate.test(array), "Single element matching the value should return true");
  }

  @Test
  @Tag("specification")
  void testElementNotMatchingShouldReturnFalse() {
    SimpleArray array = new SimpleArray(5, new long[]{8});
    ContainsNumberSpecificationPredicate predicate = new ContainsNumberSpecificationPredicate(7);
    assertFalse(predicate.test(array), "Single element not matching the value should return false");
  }
}