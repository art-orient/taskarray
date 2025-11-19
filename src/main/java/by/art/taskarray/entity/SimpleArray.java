package by.art.taskarray.entity;

import by.art.taskarray.observer.SimpleArrayEvent;
import by.art.taskarray.observer.SimpleArrayObservable;
import by.art.taskarray.observer.SimpleArrayObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class SimpleArray implements SimpleArrayObservable {

  private long arrayId;
  private long[] array;
  private final List<SimpleArrayObserver> observers = new ArrayList<>();

  public SimpleArray(long arrayId, long[] array) {
    this.arrayId = arrayId;
    this.array = Arrays.copyOf(array, array.length);
    notifyObservers();
  }

  @Override
  public void attach(SimpleArrayObserver observer) {
    if (observer != null) {
      observers.add(observer);
    }
  }

  @Override
  public void detach(SimpleArrayObserver observer) {
    if (observer != null) {
      observers.remove(observer);
    }
  }

  @Override
  public void notifyObservers() {
    for (SimpleArrayObserver observer : observers) {
      observer.update(new SimpleArrayEvent(this));
    }
  }

  public long getArrayId() {
    return arrayId;
  }

  public void setArrayId(long arrayId) {
    this.arrayId = arrayId;
    notifyObservers();
  }

  public long[] getArray() {
    return Arrays.copyOf(array, array.length);
  }

  public void setArray(long[] array) {
    this.array = Arrays.copyOf(array, array.length);
    notifyObservers();
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
