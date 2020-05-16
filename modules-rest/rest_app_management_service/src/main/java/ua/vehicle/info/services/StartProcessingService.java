package ua.vehicle.info.services;

import java.net.URI;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.aspects.annotations.LogInputOutput;
import ua.vehicle.info.aspects.annotations.SuppressRuntimeExceptions;

@Service
@RequiredArgsConstructor
public class StartProcessingService {

    private final RestTemplate restTemplate;

    @LogExceptions
    @LogInputOutput
    @SuppressRuntimeExceptions
    public void startService(@NonNull URI serviceUri) {
        var processEndpoint = "/startProcessing";
        var newPath = serviceUri.getPath() + processEndpoint;
        var processUri = serviceUri.resolve(newPath);
        restTemplate.postForObject(processUri, null, Object.class);
    }

}
