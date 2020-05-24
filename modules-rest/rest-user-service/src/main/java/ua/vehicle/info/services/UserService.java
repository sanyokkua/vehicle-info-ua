package ua.vehicle.info.services;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import ua.vehicle.info.model.UserModel;

@Transactional
public interface UserService {

    UserModel create(@NonNull final UserModel entity);

    UserModel update(@NonNull final UserModel entity);

    boolean delete(final int id);

    boolean existId(final int id);

    boolean exist(@NonNull final UserModel entity);

    UserModel findOne(final int id);

    UserModel findOne(@NonNull final String email);

    Iterable<UserModel> findAll(Sort sort);

    Page<UserModel> findAll(Pageable pageable);
}
