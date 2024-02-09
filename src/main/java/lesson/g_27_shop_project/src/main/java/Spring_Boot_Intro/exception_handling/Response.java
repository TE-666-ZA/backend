package Spring_Boot_Intro.exception_handling;

public class Response {

  private String message;

  public Response(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
