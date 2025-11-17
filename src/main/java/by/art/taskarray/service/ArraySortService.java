package by.art.taskarray.service;

import by.art.taskarray.entity.SimpleArray;

interface ArrayValueService {

  long selectMin(SimpleArray array);

  long selectMax(SimpleArray array);


}
