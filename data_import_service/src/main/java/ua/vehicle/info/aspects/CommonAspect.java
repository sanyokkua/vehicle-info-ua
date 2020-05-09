package ua.vehicle.info.aspects;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import org.aspectj.lang.JoinPoint;

public abstract class CommonAspect {

    protected static final String LINE_BEFORE = "\n-------------------BEFORE----------------------";
    protected static final String LINE_AFTER = "\n-------------------AFTER-----------------------";
    protected static final String BEFORE = "before: %s";
    protected static final String AFTER = "after: %s";
    protected static final String TIME = "time: %s";
    protected static final String ARGS = "args: %s";
    protected static final String ERROR = "exception: %s, message: %s";
    protected static final String RETURN = "return: %s";

    protected String getArguments(JoinPoint joinPoint) {
        return Arrays.stream(joinPoint.getArgs())
                .map(Optional::ofNullable)
                .map(opt -> opt.orElse("null"))
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }
}
