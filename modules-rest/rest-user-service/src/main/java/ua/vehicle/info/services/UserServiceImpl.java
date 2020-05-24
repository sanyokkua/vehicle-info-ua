package ua.vehicle.info.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.vehicle.info.aspects.EncryptPassword;
import ua.vehicle.info.model.UserModel;
import ua.vehicle.info.repositories.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @EncryptPassword
    @Override
    public UserModel create(@NonNull UserModel entity) {
        return repository.save(entity);
    }

    @EncryptPassword
    @Override
    public UserModel update(@NonNull UserModel entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean existId(int id) {
        return repository.existsById(id);
    }

    @EncryptPassword
    @Override
    public boolean exist(@NonNull UserModel entity) {
        return repository.existsByEmail(entity.getEmail());
    }

    @Override
    public UserModel findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserModel findOne(@NonNull String email) {
        return repository.findByEmail(email).orElse(null);
    }

    @Override
    public Iterable<UserModel> findAll(Sort sort) {
        return repository.findAll();
    }

    @Override
    public Page<UserModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
