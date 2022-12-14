package task.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import task.restapi.mapper.CartMapper;
import task.restapi.mapper.ProductMapper;
import task.restapi.mapper.request.UserRequest;
import task.restapi.mapper.response.CartResponse;
import task.restapi.mapper.response.ProductResponse;
import task.restapi.mapper.response.UserResponse;
import task.restapi.entity.User;
import task.restapi.mapper.UserMapper;
import task.restapi.repository.UserRepository;
import task.restapi.service.interfaces.UserServiceInterface;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final CartMapper cartMapper;

    private final ProductMapper productMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return userMapper.fromEntitiesToResponseList(userRepository.findAllByOrderByIdAsc());
    }

    @Override
    public User getUserEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "User not found with id: " + id));
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userMapper.fromEntityToResponse(getUserEntityById(id));
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User userEntity = userMapper.fromRequestToEntity(userRequest);
        userEntity.setRegisteredAt(new Date());
        return userMapper.fromEntityToResponse(userRepository.save(userEntity));
    }

    @Override
    public Void updateUser(Long id, UserRequest userRequest) {
        User user = getUserEntityById(id);
        BeanUtils.copyProperties(userRequest, user, "id", "registeredAt");
        userRepository.save(user);
        return null;
    }

    @Override
    public Void deleteUser(Long id) {
        userRepository.delete(getUserEntityById(id));
        return null;
    }

    @Override
    public List<CartResponse> getUserCarts(Long userId) {
        List<CartResponse> userCarts = cartMapper.fromEntitiesToResponseList(getUserEntityById(userId).getCarts());
        userCarts.sort(Comparator.comparing(CartResponse::getId));
        return userCarts;
    }

    @Override
    public List<ProductResponse> getUserProducts(Long id) {
        List<ProductResponse> userProducts = productMapper.fromEntitiesToResponseList(getUserEntityById(id).getProducts());
        userProducts.sort(Comparator.comparing(ProductResponse::getId));
        return userProducts;
    }
}
