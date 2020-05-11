package ua.vehicle.info.persist;

import lombok.extern.slf4j.Slf4j;
import ua.vehicle.info.dto.ServiceCenterRecord;
import ua.vehicle.info.listeners.OnMessageListener;

@Slf4j
public class ServiceCenterPersistListener implements OnMessageListener<ServiceCenterRecord> {

    @Override
    public void onMessage(ServiceCenterRecord message) {
        log.info("Message to persist: {}", message);
    }
}
