package ua.vehicle.info.discovery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The enum Services.
 */
@Getter
@RequiredArgsConstructor
public enum Services {
    /**
     * Inf api gateway service services.
     */
    INF_API_GATEWAY_SERVICE(ServicesNamesConstants.INF_API_GATEWAY_SERVICE),
    /**
     * Inf authentication service services.
     */
    INF_AUTHENTICATION_SERVICE(ServicesNamesConstants.INF_AUTHENTICATION_SERVICE),
    /**
     * Import admin unit service services.
     */
    IMPORT_ADMIN_UNIT_SERVICE(ServicesNamesConstants.IMPORT_ADMIN_UNIT_SERVICE),
    /**
     * Import persistence service services.
     */
    IMPORT_PERSISTENCE_SERVICE(ServicesNamesConstants.IMPORT_PERSISTENCE_SERVICE),
    /**
     * Import registration service services.
     */
    IMPORT_REGISTRATION_SERVICE(ServicesNamesConstants.IMPORT_REGISTRATION_SERVICE),
    /**
     * Import service center service services.
     */
    IMPORT_SERVICE_CENTER_SERVICE(ServicesNamesConstants.IMPORT_SERVICE_CENTER_SERVICE),
    /**
     * Rest app management service services.
     */
    REST_APP_MANAGEMENT_SERVICE(ServicesNamesConstants.REST_APP_MANAGEMENT_SERVICE),
    /**
     * Rest search service services.
     */
    REST_SEARCH_SERVICE(ServicesNamesConstants.REST_SEARCH_SERVICE),
    /**
     * Rest user search service services.
     */
    REST_USER_SEARCH_SERVICE(ServicesNamesConstants.REST_USER_SEARCH_SERVICE),
    /**
     * Rest user service services.
     */
    REST_USER_SERVICE(ServicesNamesConstants.REST_USER_SERVICE);

    private final String serviceName;
}
