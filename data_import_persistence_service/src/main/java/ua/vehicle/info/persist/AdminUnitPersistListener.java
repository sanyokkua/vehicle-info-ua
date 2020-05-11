package ua.vehicle.info.persist;

import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.dto.AdminUnitRecord;
import ua.vehicle.info.listeners.OnMessageListener;

@Slf4j
public class AdminUnitPersistListener implements OnMessageListener<AdminUnitRecord> {

    @Override
    public void onMessage(AdminUnitRecord message) {
        log.info("Message to persist: {}", message);
    }
}
