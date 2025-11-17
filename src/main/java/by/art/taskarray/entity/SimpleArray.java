package by.art.taskarray.entity;

import java.util.Arrays;
import java.util.StringJoiner;

public class SimpleArray {
  private long[] array;

  public SimpleArray(long[] array) {
    this.array = array;
  }

  public void setArray(long[] array) {
    this.array = array;
  }

  public long[] getArray() {
    return array;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SimpleArray that = (SimpleArray) o;

    return Arrays.equals(array, that.array);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(array);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", SimpleArray.class.getSimpleName() + "[", "]")
            .add("array=" + Arrays.toString(array))
            .toString();
  }
}
