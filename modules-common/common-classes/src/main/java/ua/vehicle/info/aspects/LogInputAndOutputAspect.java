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

/**
 * The type Log input and output aspect.
 */
@Slf4j
@Aspect
@Component
public class LogInputAndOutputAspect extends CommonAspect {

    /**
     * Log method params and output.
     */
    @Pointcut("@annotation(ua.vehicle.info.aspects.annotations.LogInputOutput)")
    public void logMethodParamsAndOutput() {
        // Empty because it is just creation of Pointcut
    }

    /**
     * Before.
     *
     * @param joinPoint the join point
     */
    @Before("logMethodParamsAndOutput()")
    public void before(JoinPoint joinPoint) {
        var info = getJointPointInfo(joinPoint);
        var arguments = getArguments(joinPoint);
        log.info("{} invoked with args: {}", info, arguments);
    }

    /**
     * After.
     *
     * @param joinPoint the join point
     */
    @After("logMethodParamsAndOutput()")
    public void after(JoinPoint joinPoint) {
        log.info("Method {} finished", joinPoint.toShortString());
    }

    /**
     * After return.
     *
     * @param joinPoint the join point
     * @param retVal the ret val
     */
    @AfterReturning(pointcut = "logMethodParamsAndOutput()", returning = "retVal")
    public void afterReturn(JoinPoint joinPoint, Object retVal) {
        var info = getJointPointInfo(joinPoint);
        var value = Optional.ofNullable(retVal).orElse("null").toString();
        log.info("{} finished, returned value is {}", info, value);
    }
}
