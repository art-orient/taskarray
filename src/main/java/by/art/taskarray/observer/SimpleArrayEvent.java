package by.art.taskarray.observer;

import by.art.taskarray.entity.SimpleArray;

import java.util.EventObject;

public class SimpleArrayEvent extends EventObject {

  public SimpleArrayEvent(SimpleArray source) {
    super(source);
  }

  @Override
  public SimpleArray getSource() {
    return (SimpleArray) super.getSource();
  }
}
