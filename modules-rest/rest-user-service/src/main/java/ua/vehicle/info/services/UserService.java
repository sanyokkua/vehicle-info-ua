package ua.vehicle.info.services;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import ua.vehicle.info.model.UserModel;

/**
 * The interface User service.
 */
@Transactional
public interface UserService {

    /**
     * Create user model.
     *
     * @param entity the entity
     *
     * @return the user model
     */
    UserModel create(@NonNull final UserModel entity);

    /**
     * Update user model.
     *
     * @param entity the entity
     *
     * @return the user model
     */
    UserModel update(@NonNull final UserModel entity);

    /**
     * Delete boolean.
     *
     * @param id the id
     *
     * @return the boolean
     */
    boolean delete(final int id);

    /**
     * Exist id boolean.
     *
     * @param id the id
     *
     * @return the boolean
     */
    boolean existId(final int id);

    /**
     * Exist boolean.
     *
     * @param entity the entity
     *
     * @return the boolean
     */
    boolean exist(@NonNull final UserModel entity);

    /**
     * Find one user model.
     *
     * @param id the id
     *
     * @return the user model
     */
    UserModel findOne(final int id);

    /**
     * Find one user model.
     *
     * @param email the email
     *
     * @return the user model
     */
    UserModel findOne(@NonNull final String email);

    /**
     * Find all iterable.
     *
     * @param sort the sort
     *
     * @return the iterable
     */
    Iterable<UserModel> findAll(Sort sort);

    /**
     * Find all page.
     *
     * @param pageable the pageable
     *
     * @return the page
     */
    Page<UserModel> findAll(Pageable pageable);
}
