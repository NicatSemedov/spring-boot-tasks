package task.restapi.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import task.restapi.dto.request.UserRequest;
import task.restapi.dto.response.UserResponse;
import task.restapi.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "passwordHash", source = "password")

    @Mapping(target = "registeredAt", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    @Mapping(target = "carts", ignore = true)
    User fromRequestToEntity(UserRequest userRequest);

    UserResponse fromEntityToResponse(User user);

    List<UserResponse> fromEntitiesToResponseList(List<User> users);
}
