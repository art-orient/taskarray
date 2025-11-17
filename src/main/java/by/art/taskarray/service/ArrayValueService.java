package by.art.taskarray.service;

import by.art.taskarray.entity.SimpleArray;

interface ArrayValueService {

  long min(SimpleArray array);

  long max(SimpleArray array);

  long average(SimpleArray array);
}
