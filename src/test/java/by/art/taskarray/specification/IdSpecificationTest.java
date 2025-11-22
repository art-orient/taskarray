package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdSpecificationTest {

  @Test
  @Tag("specification")
  void testIdMatchesShouldReturnTrue() {
    SimpleArray array = new SimpleArray(5, new long[]{1, 2, 3});
    IdSpecification spec = new IdSpecification(5);
    assertTrue(spec.specify(array));
  }

  @Test
  @Tag("specification")
  void testIdDoesNotMatchShouldReturnFalse() {
    SimpleArray array = new SimpleArray(10, new long[]{10, 12, 15});
    IdSpecification spec = new IdSpecification(5);
    assertFalse(spec.specify(array));
  }
}