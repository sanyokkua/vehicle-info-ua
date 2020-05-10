package ua.vehicle.info.aspects;

import java.time.Duration;
import java.time.LocalTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogExecutionTimeAspect {

    @Pointcut("@annotation(ua.vehicle.info.aspects.annotations.LogTimeMeasures)")
    public void logExecutionTime() {
        // Empty because it is just creation of Pointcut
    }

    @Around("logExecutionTime()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        var start = LocalTime.now();
        var proceed = joinPoint.proceed();
        var finish = LocalTime.now();
        var method = joinPoint.toShortString();
        var duration = Duration.between(start, finish);
        log.info("Method: {}, start time: {}, finish time: {}", method, start, finish);
        log.info("Method: {}, execution time: in min - {}, in sec - {}, in millis - {}, in nano - {}",
                method,
                duration.toMinutes(),
                duration.toSeconds(),
                duration.toMillis(),
                duration.toNanos());
        return proceed;
    }
}
