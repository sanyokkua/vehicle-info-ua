package ua.vehicle.info.repositories;

import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.vehicle.info.model.UserModel;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserModel, Integer> {

    boolean existsByEmail(String email);

    Optional<UserModel> findByEmail(String email);
}
