package ua.vehicle.info.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.persist.chain.Handler;

@Slf4j
@RequiredArgsConstructor
public class RegistrationPersistListener implements OnMessageListener<RegistrationRecord> {

    private final Handler<RegistrationRecord> registrationDtoHandler;

    @LogExceptions
    @Override
    public void onMessage(RegistrationRecord message) {
        registrationDtoHandler.handle(message);
    }
}
