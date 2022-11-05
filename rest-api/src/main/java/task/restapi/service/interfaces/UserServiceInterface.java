package task.restapi.service.interfaces;

import task.restapi.dto.request.UserRequest;
import task.restapi.dto.response.CartResponse;
import task.restapi.dto.response.UserResponse;
import task.restapi.entity.User;

import java.util.List;

public interface UserServiceInterface {
    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse saveUser(UserRequest user);

    Void updateUser(Long id, UserRequest user);

    Void deleteUser(Long id);

    List<CartResponse> getUserCarts(Long id);

    User getUserEntityById(Long userId);
}
