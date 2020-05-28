package ua.vehicle.info.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.info.discovery.Services;

@Service
@RequiredArgsConstructor
public class ServicesInformationService {

    private final DiscoveryClient discoveryClient;

    @LogExceptions
    @LogInputOutput
    @SuppressRuntimeExceptions
    public List<String> getAppServices() {
        return Stream.of(Services.values())
                .map(Services::getServiceName)
                .sorted()
                .collect(Collectors.toList());
    }

    @LogExceptions
    @LogInputOutput
    @SuppressRuntimeExceptions
    public List<String> getRunningAppServices() {
        return discoveryClient.getServices()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
