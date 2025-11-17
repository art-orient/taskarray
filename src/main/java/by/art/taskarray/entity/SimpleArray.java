package by.art.taskarray.entity;

import java.util.Arrays;
import java.util.StringJoiner;

public class SimpleArray {

  private long arrayId;
  private long[] array;

  public SimpleArray(long arrayId, long[] array) {
    this.arrayId = arrayId;
    this.array = Arrays.copyOf(array, array.length);
  }

  public long getArrayId() {
    return arrayId;
  }

  public void setArrayId(long arrayId) {
    this.arrayId = arrayId;
  }

  public long[] getArray() {
    return Arrays.copyOf(array, array.length);
  }

  public void setArray(long[] array) {
    this.array = Arrays.copyOf(array, array.length);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SimpleArray that = (SimpleArray) o;
    if (arrayId != that.arrayId) return false;
    return Arrays.equals(array, that.array);
  }

  @Override
  public int hashCode() {
    return (int) (31 * arrayId + Arrays.hashCode(array));
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", SimpleArray.class.getSimpleName() + "[", "]")
            .add("arrayId=" + arrayId)
            .add("array=" + Arrays.toString(array))
            .toString();
  }
}
