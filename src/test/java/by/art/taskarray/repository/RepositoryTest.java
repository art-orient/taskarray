package by.art.taskarray.repository;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.exception.SimpleArrayException;
import by.art.taskarray.specification.Specification;
import by.art.taskarray.specification.SpecificationPredicate;
import org.junit.jupiter.api.*;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RepositoryTest {

  Repository repository;
  SimpleArray array1 = new SimpleArray(1, new long[]{1});
  SimpleArray array2 = new SimpleArray(2, new long[]{2});

  @BeforeEach
  void setUp() {
    repository = Repository.getInstance();
  }

  @AfterEach
  void tearDown() {
    repository.queryStream(s -> true).forEach(array -> {
      try {
        repository.remove(array);
      } catch (SimpleArrayException ignored) {}
    });
  }

  @Test
  @Tag("repository")
  void addSingleSimpleArrayShouldAddSuccessfully() throws SimpleArrayException {
    repository.add(array1);
    List<SimpleArray> result = repository.queryStream(s -> true);
    assertTrue(result.contains(array1));
  }

  @Test
  @Tag("repository")
  void addNullSimpleArrayShouldThrowException() {
    SimpleArrayException exception = assertThrows(SimpleArrayException.class,
            () -> repository.add((SimpleArray) null));
    assertTrue(exception.getMessage().contains("SimpleArray is null"));
  }

  @Test
  @Tag("repository")
  void addListOfSimpleArraysShouldAddSuccessfully() throws SimpleArrayException {
    repository.add(List.of(array1, array2));
    List<SimpleArray> result = repository.queryStream(s -> true);
    assertTrue(result.containsAll(List.of(array1, array2)));
  }

  @Test
  @Tag("repository")
  void addNullListShouldThrowException() {
    SimpleArrayException exception = assertThrows(SimpleArrayException.class,
            () -> repository.add((List<SimpleArray>) null));
    assertTrue(exception.getMessage().contains("List of SimpleArrays is null"));
  }

  @Test
  @Tag("repository")
  void removeSimpleArrayShouldRemoveSuccessfully() throws SimpleArrayException {
    repository.add(array1);
    repository.remove(array1);
    List<SimpleArray> result = repository.queryStream(s -> true);
    assertFalse(result.contains(array1));
  }

  @Test
  @Tag("repository")
  void removeNullSimpleArrayShouldThrowException() {
    SimpleArrayException exception = assertThrows(SimpleArrayException.class,
            () -> repository.remove(null));
    assertTrue(exception.getMessage().contains("SimpleArray is null"));
  }

  @Test
  @Tag("repository")
  void removeByIndexShouldRemoveSuccessfully() throws SimpleArrayException {
    repository.add(array1);
    repository.remove(0);
    List<SimpleArray> result = repository.queryStream(s -> true);
    assertFalse(result.contains(array1));
  }

  @Test
  @Tag("repository")
  void removeByInvalidIndexShouldThrowException() {
    SimpleArrayException exception = assertThrows(SimpleArrayException.class,
            () -> repository.remove(-1));
    assertTrue(exception.getMessage().contains("Wrong index"));
  }

  @Test
  @Tag("repository")
  void sortShouldSortByComparator() throws SimpleArrayException {
    repository.add(List.of(array2, array1));
    List<SimpleArray> sorted = repository.sort(Comparator.comparingLong(SimpleArray::getArrayId));
    assertEquals(array1, sorted.get(0));
    assertEquals(array2, sorted.get(1));
  }

  @Test
  @Tag("repository")
  void queryShouldReturnMatchingArrays() throws SimpleArrayException {
    repository.add(List.of(array1, array2));
    Specification specification = mock(Specification.class);
    when(specification.specify(array1)).thenReturn(true);
    when(specification.specify(array2)).thenReturn(false);
    List<SimpleArray> result = repository.query(specification);
    assertAll (
            () -> assertEquals(1, result.size()),
            () -> assertTrue(result.contains(array1)),
            () -> assertFalse(result.contains(array2))
    );
  }

  @Test
  @Tag("repository")
  void queryStreamShouldReturnMatchingArrays() throws SimpleArrayException {
    repository.add(List.of(array1, array2));
    Specification specification = s -> s.getArrayId() == 2;
    List<SimpleArray> result = repository.queryStream(specification);
    assertAll(
            () -> assertEquals(1, result.size()),
            () -> assertEquals(array2, result.get(0))
    );
  }

  @Test
  @Tag("repository")
  void queryStreamPredicateShouldReturnMatchingArrays() throws SimpleArrayException {
    repository.add(List.of(array1, array2));
    SpecificationPredicate pred = s -> s.getArrayId() == 1;
    List<SimpleArray> result = repository.queryStreamPredicate(pred);
    assertAll(
            () -> assertEquals(1, result.size()),
            () -> assertEquals(array1, result.get(0))
    );
  }
}