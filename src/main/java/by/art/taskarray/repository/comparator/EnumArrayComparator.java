package by.art.taskarray.repository.comparator;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.ArrayValueService;
import by.art.taskarray.service.impl.ArrayValueServiceImpl;
import java.util.Comparator;

public enum EnumArrayComparator implements Comparator<SimpleArray> {
  ID {
    @Override
    public int compare(SimpleArray array1, SimpleArray array2) {
      return (int) (array1.getArrayId() - array2.getArrayId());
    }
  },

  MIN {
    @Override
    public int compare(SimpleArray array1, SimpleArray array2) {
      ArrayValueService service = new ArrayValueServiceImpl();
      long min1 = service.min(array1).getAsLong();
      long min2 = service.min(array2).getAsLong();
      return Long.compare(min1, min2);
    }
  },

  MAX {
    @Override
    public int compare(SimpleArray array1, SimpleArray array2) {
      ArrayValueService service = new ArrayValueServiceImpl();
      long max1 = service.max(array1).getAsLong();
      long max2 = service.max(array2).getAsLong();
      return Long.compare(max1, max2);
    }
  },

  SUM {
    @Override
    public int compare(SimpleArray array1, SimpleArray array2) {
      ArrayValueService service = new ArrayValueServiceImpl();
      long sum1 = service.sum(array1).getAsLong();
      long sum2 = service.sum(array2).getAsLong();
      return Long.compare(sum1, sum2);
    }
  },

  FIRST {
    @Override
    public int compare(SimpleArray simpleArray1, SimpleArray simpleArray2) {
      long[] array1 = simpleArray1.getArray();
      long[] array2 = simpleArray2.getArray();
      long first1 = array1[0];
      long first2 = array2[0];
      return Long.compare(first1, first2);
    }
  }
}
