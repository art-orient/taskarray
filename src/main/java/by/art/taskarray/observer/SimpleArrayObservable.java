package by.art.taskarray.observer;

public interface SimpleArrayObservable {

  void attach(SimpleArrayObserver observer);

  void detach(SimpleArrayObserver observer);

  void notifyObservers();
}
