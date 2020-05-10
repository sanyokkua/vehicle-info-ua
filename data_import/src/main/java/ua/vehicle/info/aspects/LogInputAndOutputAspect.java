package ua.vehicle.info.aspects;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogInputAndOutputAspect extends CommonAspect {

    @Pointcut("@annotation(ua.vehicle.info.aspects.annotations.LogInputOutput)")
    public void logMethodParamsAndOutput() {
        // Empty because it is just creation of Pointcut
    }

    @Before("logMethodParamsAndOutput()")
    public void before(JoinPoint joinPoint) {
        var jointPointStr = joinPoint.toShortString();
        var arguments = getArguments(joinPoint);
        log.info("Method {} invoked with args: {}", jointPointStr, arguments);
    }

    @After("logMethodParamsAndOutput()")
    public void after(JoinPoint joinPoint) {
        log.info("Method {} finished", joinPoint.toShortString());
    }

    @AfterReturning(pointcut = "logMethodParamsAndOutput()", returning = "retVal")
    public void afterReturn(JoinPoint joinPoint, Object retVal) {
        var jointPointStr = joinPoint.toShortString();
        var value = Optional.ofNullable(retVal).orElse("null").toString();
        log.info("Method {} finished, returned value is {}", jointPointStr, value);
    }
}
