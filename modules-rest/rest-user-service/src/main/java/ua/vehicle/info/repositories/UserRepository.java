package ua.vehicle.info.repositories;

import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.model.UserModel;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserModel, Integer> {

    /**
     * Exists by email boolean.
     *
     * @param email the email
     *
     * @return the boolean
     */
    boolean existsByEmail(String email);

    /**
     * Find by email optional.
     *
     * @param email the email
     *
     * @return the optional
     */
    Optional<UserModel> findByEmail(String email);
}
