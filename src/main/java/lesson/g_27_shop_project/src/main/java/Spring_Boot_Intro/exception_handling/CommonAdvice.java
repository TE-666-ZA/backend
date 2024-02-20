package Spring_Boot_Intro.exception_handling;

import Spring_Boot_Intro.exception_handling.exceptions_for_test.FourthTestException;
import Spring_Boot_Intro.exception_handling.exceptions_for_test.ThirdTestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonAdvice {

  @ExceptionHandler(ThirdTestException.class)
  public ResponseEntity<Response> handleException(ThirdTestException e){
    Response response = new Response(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
  }

  @ExceptionHandler(FourthTestException.class)
  public ResponseEntity<Response> handleException(FourthTestException e){
    Response response = new Response(e.getMessage());
    return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
  }
}
