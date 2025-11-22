package by.art.taskarray.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdGeneratorTest {

  @BeforeEach
  void resetCounter() throws Exception {
    // Сбрасываем counter через рефлексию для чистых тестов
    var field = IdGenerator.class.getDeclaredField("counter");
    field.setAccessible(true);
    field.setLong(null, 1);
  }

  @Test
  @Tag("util")
  void generateIdShouldReturnIncrementedValues() {
    long first = IdGenerator.generateId();
    long second = IdGenerator.generateId();
    long third = IdGenerator.generateId();
    assertAll (
            () -> assertEquals(1, first),
            () -> assertEquals(2, second),
            () -> assertEquals(3, third)
    );
  }
}