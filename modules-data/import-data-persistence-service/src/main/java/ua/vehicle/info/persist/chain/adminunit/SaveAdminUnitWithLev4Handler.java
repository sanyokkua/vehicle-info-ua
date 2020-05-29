package ua.vehicle.info.persist.chain.adminunit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.registration.AdminUnitDto;
import ua.vehicle.info.persist.repository.registration.AdminUnitJdbcRepository;

/**
 * The type Save admin unit with lev 4 handler.
 */
@Component
public class SaveAdminUnitWithLev4Handler extends AdminUnitHandler {

    /**
     * Instantiates a new Save admin unit with lev 4 handler.
     *
     * @param repository the repository
     */
    public SaveAdminUnitWithLev4Handler(AdminUnitJdbcRepository repository) {
        super(repository);
    }

    @LogExceptions
    @Override
    protected String getUnitNumber(AdminUnitDto obj) {
        return obj.getLevel4Code();
    }

    @LogExceptions
    @Override
    protected boolean canHandle(AdminUnitDto obj) {
        return StringUtils.isNotBlank(obj.getLevel4Code());
    }
}
