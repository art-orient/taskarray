package by.art.taskarray.observer.imol;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.entity.SimpleArrayStatistic;
import by.art.taskarray.observer.SimpleArrayEvent;
import by.art.taskarray.observer.SimpleArrayObserver;
import by.art.taskarray.observer.impl.SimpleArrayObserverImpl;
import by.art.taskarray.warehouse.Warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SimpleArrayObserverImplTest {
  private Warehouse warehouse;
  private SimpleArrayObserver observer;

  @BeforeEach
  void setUp() {
    warehouse = Warehouse.getInstance();
    observer = new SimpleArrayObserverImpl();
  }

  @AfterEach
  void tearDown() {
    warehouse = null;
    observer = null;
  }

  @Test
  @Tag("observer")
  void update_shouldCreateAndStoreStatisticsInWarehouse() {
    long arrayId = 22;
    long[] testArray = {5, -2, 10};
    SimpleArray simpleArray = new SimpleArray(arrayId, testArray);
    SimpleArrayEvent event = mock(SimpleArrayEvent.class);
    when(event.getSource()).thenReturn(simpleArray);
    observer.update(event);
    SimpleArrayStatistic statistic = warehouse.getParameters(arrayId).get();
    assertAll(
            () -> assertNotNull(statistic),
            () -> assertEquals(-2, statistic.getMin()),
            () -> assertEquals(10, statistic.getMax()),
            () -> assertEquals(13, statistic.getSum())
    );
  }

  @Test
  @Tag("observer")
  void update_shouldOverrideExistingStatistic() {
    long arrayId = 1;
    warehouse.put(arrayId, new SimpleArrayStatistic(0, 0, 0)); // pre-existing
    SimpleArray simpleArray = new SimpleArray(arrayId, new long[]{3, 3, 3});
    SimpleArrayEvent event = mock(SimpleArrayEvent.class);
    when(event.getSource()).thenReturn(simpleArray);
    observer.update(event);
    SimpleArrayStatistic statistic = warehouse.getParameters(arrayId).get();
    assertAll(
            () -> assertNotNull(statistic),
            () -> assertEquals(3, statistic.getMin()),
            () -> assertEquals(3, statistic.getMax()),
            () -> assertEquals(9, statistic.getSum())
    );
  }
}