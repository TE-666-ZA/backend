package Spring_Boot_Intro.logging;

import java.util.logging.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogging {

  private Logger logger = (Logger) LoggerFactory.getLogger(AspectLogging.class);

  @Pointcut("execution"())
}
