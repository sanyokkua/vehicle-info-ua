package ua.vehicle.info.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SuppressRuntimeExceptionsAspect extends CommonAspect {

    @Pointcut("@annotation(ua.vehicle.info.aspects.annotations.LogExceptions)")
    public void suppress() {
        // Empty because it is just creation of Pointcut
    }

    @Around("suppress()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (RuntimeException ex) {
            log.warn("Method: {} thrown an exception: {}, null is returned",
                    joinPoint.toShortString(),
                    ex.toString());
            return null;
        }
    }
}
