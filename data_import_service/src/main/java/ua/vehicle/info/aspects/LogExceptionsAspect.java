package ua.vehicle.info.aspects;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogExceptionsAspect extends CommonAspect {

    @Pointcut("@annotation(LogOnlyException)")
    public void logOnlyExceptions() {
        // Empty because it is just creation of Pointcut
    }

    @AfterThrowing(pointcut = "logOnlyExceptions()", throwing = "ex")
    public void afterException(JoinPoint joinPoint, Exception ex) {
        var jointPointStr = joinPoint.toString();
        var time = LocalDateTime.now().toString();
        var exception = ex.toString();
        var exceptionMessage = ex.getMessage();
        var arguments = getArguments(joinPoint);

        log.error(String.format(AFTER, jointPointStr));
        log.error(String.format(TIME, time));
        log.error(String.format(ARGS, arguments));
        log.error(String.format(ERROR, exception, exceptionMessage));
        log.error(LINE_AFTER);
    }
}
