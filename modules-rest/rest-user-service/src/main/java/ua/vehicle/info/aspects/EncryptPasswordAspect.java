package ua.vehicle.info.aspects;

import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ua.vehicle.info.model.UserModel;
import ua.vehicle.info.utils.UserModelPasswordUtils;

@Slf4j
@Component
@Aspect
@RequiredArgsConstructor
public class EncryptPasswordAspect {

    private final UserModelPasswordUtils userModelPasswordUtils;

    @Pointcut("@annotation(ua.vehicle.info.aspects.EncryptPassword)")
    public void encryptPassword() {
        // Empty because it is just creation of Pointcut
    }

    @Around("encryptPassword()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Password will be encrypted inside jointPoint");
        UserModel userModel = Stream.of(joinPoint.getArgs())
                .filter(obj -> obj instanceof UserModel)
                .map(obj -> (UserModel) obj)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no any UserModel in args"));
        UserModel encrypt = userModelPasswordUtils.encrypt(userModel);
        log.info("Password is encrypted inside jointPoint");
        return joinPoint.proceed(new Object[] {encrypt});
    }
}
