package by.art.taskarray.statistic;

import java.util.StringJoiner;

public class SimpleArrayStatistic {
  private long min;
  private long max;
  private long sum;

  public SimpleArrayStatistic(long min, long max, long sum) {
    this.min = min;
    this.max = max;
    this.sum = sum;
  }

  public long getMin() {
    return min;
  }

  public void setMin(long min) {
    this.min = min;
  }

  public long getMax() {
    return max;
  }

  public void setMax(long max) {
    this.max = max;
  }

  public long getSum() {
    return sum;
  }

  public void setSum(long sum) {
    this.sum = sum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SimpleArrayStatistic that = (SimpleArrayStatistic) o;

    if (min != that.min) return false;
    if (max != that.max) return false;
    return sum == that.sum;
  }

  @Override
  public int hashCode() {
    int result = (int) (min ^ (min >>> 32));
    result = 31 * result + (int) (max ^ (max >>> 32));
    result = 31 * result + (int) (sum ^ (sum >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", SimpleArrayStatistic.class.getSimpleName() + "[", "]")
            .add("min=" + min)
            .add("max=" + max)
            .add("sum=" + sum)
            .toString();
  }
}
