package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.specification.id.IdEqualsSpecification;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdEqualsSpecificationTest {

  @Test
  @Tag("specification")
  void testIdMatchesShouldReturnTrue() {
    SimpleArray array = new SimpleArray(5, new long[]{1, 2, 3});
    IdEqualsSpecification spec = new IdEqualsSpecification(5);
    assertTrue(spec.specify(array));
  }

  @Test
  @Tag("specification")
  void testIdDoesNotMatchShouldReturnFalse() {
    SimpleArray array = new SimpleArray(10, new long[]{10, 12, 15});
    IdEqualsSpecification spec = new IdEqualsSpecification(5);
    assertFalse(spec.specify(array));
  }
}