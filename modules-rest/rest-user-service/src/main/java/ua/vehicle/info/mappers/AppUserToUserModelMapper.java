package ua.vehicle.info.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ua.vehicle.info.api.dto.users.AppUser;
import ua.vehicle.info.model.UserModel;

/**
 * The interface App user to user model mapper.
 */
@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface AppUserToUserModelMapper {

    /**
     * Map to user model user model.
     *
     * @param input the input
     *
     * @return the user model
     */
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    UserModel mapToUserModel(AppUser input);

    /**
     * Map to app user app user.
     *
     * @param input the input
     *
     * @return the app user
     */
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    AppUser mapToAppUser(UserModel input);
}
