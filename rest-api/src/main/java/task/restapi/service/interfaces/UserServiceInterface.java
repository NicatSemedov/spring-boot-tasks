package task.restapi.service.interfaces;

import task.restapi.mapper.request.UserRequest;
import task.restapi.mapper.response.CartResponse;
import task.restapi.mapper.response.ProductResponse;
import task.restapi.mapper.response.UserResponse;
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

    List<ProductResponse> getUserProducts(Long id);
}
