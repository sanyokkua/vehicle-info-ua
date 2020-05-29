package ua.vehicle.info.persist.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Component;
import ua.vehicle.info.aspects.annotations.LogExceptions;

/**
 * The type Insert functionality repository.
 *
 * @param <T> the type parameter
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class InsertFunctionalityRepositoryImpl<T> implements InsertFunctionalityRepository<T> {

    private final JdbcAggregateTemplate jdbcAggregateTemplate;

    @LogExceptions
    @Override
    public <S extends T> S customInsert(S entity) {
        return jdbcAggregateTemplate.insert(entity);
    }
}
