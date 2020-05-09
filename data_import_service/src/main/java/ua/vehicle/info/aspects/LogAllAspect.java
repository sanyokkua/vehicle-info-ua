package ua.vehicle.info.aspects;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAllAspect extends CommonAspect {

    @Pointcut("@annotation(LogInputOutput)")
    public void logMethodParamsAndOutput() {
        // Empty because it is just creation of Pointcut
    }

    @Before("logMethodParamsAndOutput()")
    public void before(JoinPoint joinPoint) {
        var jointPointStr = joinPoint.toString();
        var time = LocalDateTime.now().toString();
        var arguments = getArguments(joinPoint);
        log.info(LINE_BEFORE);
        log.info(String.format(BEFORE, jointPointStr));
        log.info(String.format(TIME, time));
        log.info(String.format(ARGS, arguments));
    }

    @After("logMethodParamsAndOutput()")
    public void after(JoinPoint joinPoint) {
        var jointPointStr = joinPoint.toString();
        var time = LocalDateTime.now().toString();

        log.info(String.format(AFTER, jointPointStr));
        log.info(String.format(TIME, time));
        log.info(LINE_AFTER);
    }

    @AfterThrowing(pointcut = "logMethodParamsAndOutput()", throwing = "ex")
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

    @AfterReturning(pointcut = "logMethodParamsAndOutput()", returning = "retVal")
    public void afterReturn(JoinPoint joinPoint, Object retVal) {
        var jointPointStr = joinPoint.toString();
        var time = LocalDateTime.now().toString();
        var value = Optional.ofNullable(retVal).orElse("null").toString();

        log.info(String.format(AFTER, jointPointStr));
        log.info(String.format(TIME, time));
        log.info(String.format(RETURN, value));
        log.info(LINE_AFTER);
    }
}
