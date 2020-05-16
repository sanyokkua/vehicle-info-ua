package ua.vehicle.info.persist.chain.adminunit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;
import ua.vehicle.info.dto.registration.AdminUnitDto;
import ua.vehicle.info.persist.repository.registration.AdminUnitJdbcRepository;

@Component
public class SaveAdminUnitWithLev1Handler extends AdminUnitHandler {

    public SaveAdminUnitWithLev1Handler(AdminUnitJdbcRepository repository) {
        super(repository);
    }

    @LogExceptions
    @Override
    protected String getUnitNumber(AdminUnitDto obj) {
        return obj.getLevel1Code();
    }

    @LogExceptions
    @Override
    protected boolean canHandle(AdminUnitDto obj) {
        return StringUtils.isNotBlank(obj.getLevel1Code());
    }
}
