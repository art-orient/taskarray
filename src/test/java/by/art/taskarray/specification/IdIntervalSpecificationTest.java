package by.art.taskarray.specification;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.specification.id.IdIntervalSpecification;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdIntervalSpecificationTest {

  @Test
  @Tag("specification")
  void testIdWithinIntervalShouldReturnTrue() {
    SimpleArray array = new SimpleArray(5, new long[]{1, 2, 3});
    IdIntervalSpecification specification = new IdIntervalSpecification(1, 10);
    assertTrue(specification.specify(array));
  }

  @Test
  @Tag("specification")
  void testIdBelowIntervalShouldReturnFalse() {
    SimpleArray array = new SimpleArray(3, new long[]{1, 2, 3});
    IdIntervalSpecification specification = new IdIntervalSpecification(5, 10);
    assertFalse(specification.specify(array));
  }

  @Test
  @Tag("specification")
  void testIdAboveIntervalShouldReturnFalse() {
    SimpleArray array = new SimpleArray(15, new long[]{1, 2, 3});
    IdIntervalSpecification specification = new IdIntervalSpecification(1, 10);
    assertFalse(specification.specify(array));
  }

  @Test
  @Tag("specification")
  void testIdEqualsMinOrMaxShouldReturnTrue() {
    SimpleArray arrayMin = new SimpleArray(1, new long[]{1, 2, 3});
    SimpleArray arrayMax = new SimpleArray(10, new long[]{4, 5, 6});
    IdIntervalSpecification specification = new IdIntervalSpecification(1, 10);
    assertAll (
            () -> assertTrue(specification.specify(arrayMin)),
            () -> assertTrue(specification.specify(arrayMax))
    );
  }
}