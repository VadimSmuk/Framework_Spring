import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore() {
        System.out.println("Метод вызван");
    }

    @AfterReturning("execution(* com.example.service.*.*(..))")
    public void logAfter() {
        System.out.println("Метод выполнен");
    }
}
