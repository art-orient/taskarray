package by.art.taskarray;

import by.art.taskarray.entity.SimpleArray;
import by.art.taskarray.exception.SimpleArrayException;
import by.art.taskarray.factory.SimpleArrayFactory;
import by.art.taskarray.factory.impl.SimpleArrayFactoryImpl;
import by.art.taskarray.parser.LongNumberParser;
import by.art.taskarray.parser.impl.LongNumberParserImpl;
import by.art.taskarray.reader.DataReader;
import by.art.taskarray.reader.impl.DataReaderImpl;
import by.art.taskarray.repository.Repository;
import by.art.taskarray.service.ArraySortService;
import by.art.taskarray.service.ArrayValueService;
import by.art.taskarray.service.impl.ArraySortServiceImpl;
import by.art.taskarray.service.impl.ArrayValueServiceImpl;
import by.art.taskarray.specification.id.IdIntervalSpecification;
import by.art.taskarray.specification.Specification;
import by.art.taskarray.warehouse.Warehouse;
import java.util.List;

public class Main {
  public static void main(String[] args) throws SimpleArrayException {
    DataReader reader = new DataReaderImpl();
    List<String> linesFromFile = reader.readFile("data/data.txt");
    LongNumberParser parser = new LongNumberParserImpl();
    List<long[]> longArrays = parser.parseNumberLine(linesFromFile);
    SimpleArrayFactory factory = new SimpleArrayFactoryImpl();
    List<SimpleArray> simpleArrays = factory.createSimpleArrays(longArrays);
    ArrayValueService arrayValueService = new ArrayValueServiceImpl();
    for (SimpleArray simpleArray : simpleArrays) {
      arrayValueService.min(simpleArray);
      arrayValueService.max(simpleArray);
      arrayValueService.sum(simpleArray);
    }
    ArraySortService sortService = new ArraySortServiceImpl();
    sortService.bubbleSort(simpleArrays.get(2));
    sortService.insertionSort(simpleArrays.get(3));
    Repository repository = Repository.getInstance();
    repository.add(simpleArrays);
    Warehouse warehouse = Warehouse.getInstance();
    SimpleArray simpleArray1 = simpleArrays.get(0);
    long[] array = new long[]{55, 77, 100};
    simpleArray1.setArray(array);
    Specification specification = new IdIntervalSpecification(1, 30);
    List<SimpleArray> simpleArrayList = repository.queryStream(specification);
    warehouse.getParameters(simpleArray1.getArrayId());
    warehouse.getParameters(simpleArrayList.get(5).getArrayId());
    warehouse.getParameters(2);
    warehouse.getParameters(17);
    warehouse.getParameters(18);
  }
}
