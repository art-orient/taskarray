package by.art.taskarray.exception;

public class ArrayNotValidException extends Exception{
  public ArrayNotValidException() {
  }

  public ArrayNotValidException(String message) {
    super(message);
  }

  public ArrayNotValidException(String message, Throwable cause) {
    super(message, cause);
  }

  public ArrayNotValidException(Throwable cause) {
    super(cause);
  }
}
