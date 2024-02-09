package Spring_Boot_Intro.exception_handling;

import Spring_Boot_Intro.exception_handling.exceptions.FourthTestException;
import Spring_Boot_Intro.exception_handling.exceptions.ThirdTestException;
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
  public ResponseEntity<Response> handleEception(FourthTestException e){
    Response response = new Response(e.getMessage());
    return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
  }
}
