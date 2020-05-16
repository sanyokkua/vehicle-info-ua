package ua.vehicle.info.discovery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Services {
    INF_API_GATEWAY_SERVICE("inf-api-gateway-service"),
    INF_AUTHENTICATION_SERVICE("inf-authentication-service"),
    IMPORT_ADMIN_UNIT_SERVICE("import-admin-unit-service"),
    IMPORT_PERSISTENCE_SERVICE("import-persistence-service"),
    IMPORT_REGISTRATION_SERVICE("import-registration-service"),
    IMPORT_SERVICE_CENTER_SERVICE("import-service-center-service"),
    REST_APP_MANAGEMENT_SERVICE("rest-app-management-service"),
    REST_SEARCH_SERVICE("rest-search-service"),
    REST_USER_SEARCH_SERVICE("rest-user-search-service"),
    REST_USER_SERVICE("rest-user-service");

    private final String serviceName;
}
