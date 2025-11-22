package by.art.taskarray.warehouse;

import by.art.taskarray.entity.SimpleArrayStatistic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

  private Warehouse warehouse;

  @BeforeEach
  void setUp() {
    warehouse = Warehouse.getInstance();
  }

  @AfterEach
  void tearDown() {
    warehouse = null;
  }

  @Test
  @Tag("warehouse")
  void putAndGetParametersShouldStoreAndRetrieveStatistic() {
    SimpleArrayStatistic statistic = new SimpleArrayStatistic(1, 10, 20);
    warehouse.put(100L, statistic);
    Optional<SimpleArrayStatistic> retrieved = warehouse.getParameters(100L);
    assertAll (
            () -> assertTrue(retrieved.isPresent()),
            () -> assertEquals(statistic, retrieved.get())
    );
  }

  @Test
  @Tag("warehouse")
  void getParametersNonExistingIdShouldReturnEmptyOptional() {
    Optional<SimpleArrayStatistic> retrieved = warehouse.getParameters(999L);
    assertTrue(retrieved.isEmpty());
  }

  @Test
  @Tag("warehouse")
  void removeShouldDeleteStatistic() {
    SimpleArrayStatistic stat = new SimpleArrayStatistic(2, 20, 30);
    warehouse.put(200L, stat);
    warehouse.remove(200L);
    assertTrue(warehouse.getParameters(200L).isEmpty());
  }

  @Test
  @Tag("warehouse")
  void putOverrideShouldReplaceExistingStatistic() {
    SimpleArrayStatistic stat1 = new SimpleArrayStatistic(1, 10, 20);
    SimpleArrayStatistic stat2 = new SimpleArrayStatistic(5, 15, 25);
    warehouse.put(300L, stat1);
    SimpleArrayStatistic old = warehouse.put(300L, stat2);
    assertAll (
            () -> assertEquals(stat1, old, "put should return previous statistic"),
            () -> assertEquals(stat2, warehouse.getParameters(300L).get())
    );
  }
}