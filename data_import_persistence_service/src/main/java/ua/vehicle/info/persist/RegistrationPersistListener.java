package ua.vehicle.info.persist;

import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.dto.RegistrationRecord;
import ua.vehicle.info.listeners.OnMessageListener;

@Slf4j
public class RegistrationPersistListener implements OnMessageListener<RegistrationRecord> {

    @Override
    public void onMessage(RegistrationRecord message) {
        log.info("Message to persist: {}", message);
    }
}
