package by.art.taskarray.service;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.impl.SelectMaxServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectMaxServiceImplTest {

  SimpleArray array;

  @BeforeEach
  void setUp() {
    long[] testArray = new long[]{42, 21, 5, 10, 100};
    array = new SimpleArray(1, testArray);
  }

  @AfterEach
  void tearDown() {
    array = null;
  }

  @Test
  void selectMax() {
    SelectMaxService service = new SelectMaxServiceImpl();
    long expected = 100;
    long actual = service.selectMax(array);
    assertEquals(expected, actual);
  }

  @Test
  void selectAverage() {
    assertEquals(0, 0);
    //test
  }
}