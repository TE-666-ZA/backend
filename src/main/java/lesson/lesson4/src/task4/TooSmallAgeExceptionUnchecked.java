package task4;

public class TooSmallAgeExceptionUnchecked extends RuntimeException{

  public TooSmallAgeExceptionUnchecked(String message) {
    super(message);
  }
}
