package by.art.taskarray.comparator;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.service.ArrayValueService;
import by.art.taskarray.service.impl.ArrayValueServiceImpl;
import java.util.Comparator;

public enum ArrayValueEnumComparator implements Comparator<SimpleArray> {
  ID {
    @Override
    public int compare(SimpleArray array1, SimpleArray array2) {
      return Long.compare(array1.getArrayId(), array2.getArrayId());
    }
  },

  MIN {
    @Override
    public int compare(SimpleArray array1, SimpleArray array2) {
      long min1 = service.min(array1).orElse(Long.MAX_VALUE);
      long min2 = service.min(array2).orElse(Long.MAX_VALUE);
      return Long.compare(min1, min2);
    }
  },

  MAX {
    @Override
    public int compare(SimpleArray array1, SimpleArray array2) {
      long max1 = service.max(array1).orElse(Long.MIN_VALUE);
      long max2 = service.max(array2).orElse(Long.MIN_VALUE);
      return Long.compare(max1, max2);
    }
  },

  SUM {
    @Override
    public int compare(SimpleArray array1, SimpleArray array2) {
      long sum1 = service.sum(array1).orElse(0);
      long sum2 = service.sum(array2).orElse(0);
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
  };

  private static final ArrayValueService service = new ArrayValueServiceImpl();
}
