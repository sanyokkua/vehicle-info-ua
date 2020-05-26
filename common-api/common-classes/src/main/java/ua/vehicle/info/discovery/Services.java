package ua.vehicle.info.discovery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Services {
    INF_API_GATEWAY_SERVICE(ServicesNamesConstants.INF_API_GATEWAY_SERVICE),
    INF_AUTHENTICATION_SERVICE(ServicesNamesConstants.INF_AUTHENTICATION_SERVICE),
    IMPORT_ADMIN_UNIT_SERVICE(ServicesNamesConstants.IMPORT_ADMIN_UNIT_SERVICE),
    IMPORT_PERSISTENCE_SERVICE(ServicesNamesConstants.IMPORT_PERSISTENCE_SERVICE),
    IMPORT_REGISTRATION_SERVICE(ServicesNamesConstants.IMPORT_REGISTRATION_SERVICE),
    IMPORT_SERVICE_CENTER_SERVICE(ServicesNamesConstants.IMPORT_SERVICE_CENTER_SERVICE),
    REST_APP_MANAGEMENT_SERVICE(ServicesNamesConstants.REST_APP_MANAGEMENT_SERVICE),
    REST_SEARCH_SERVICE(ServicesNamesConstants.REST_SEARCH_SERVICE),
    REST_USER_SEARCH_SERVICE(ServicesNamesConstants.REST_USER_SEARCH_SERVICE),
    REST_USER_SERVICE(ServicesNamesConstants.REST_USER_SERVICE);

    private final String serviceName;
}
