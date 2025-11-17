package by.art.taskarray.service;

import by.art.taskarray.entity.SimpleArray;
import java.util.OptionalLong;

public interface ArrayValueService {

  OptionalLong min(SimpleArray array);

  OptionalLong max(SimpleArray array);

  OptionalLong sum(SimpleArray array);
}
