package ua.vehicle.info.aspects;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;

@Slf4j
public abstract class CommonAspect {

    protected String getArguments(JoinPoint joinPoint) {
        return Arrays.stream(joinPoint.getArgs())
                .map(Optional::ofNullable)
                .map(opt -> opt.orElse("null"))
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    protected String getJointPointInfo(JoinPoint joinPoint) {
        var className = joinPoint.getTarget().getClass().getName();
        var method = joinPoint.getSignature().getName();
        return String.format("Class: %s, method: %s", className, method);
    }
}
