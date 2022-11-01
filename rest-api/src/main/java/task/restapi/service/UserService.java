package task.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import task.restapi.dto.request.UserRequest;
import task.restapi.dto.response.UserResponse;
import task.restapi.entity.User;
import task.restapi.dto.mapper.UserMapper;
import task.restapi.repository.UserRepository;
import task.restapi.service.interfaces.UserServiceInterface;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return userMapper.fromEntitiesToResponseList(userRepository.findAllByOrderByIdAsc());
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userMapper.fromEntityToResponse(userRepository
                .findById(id).orElseThrow(() ->
                        new ResponseStatusException(NOT_FOUND)));
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User userEntity = userMapper.fromRequestToEntity(userRequest);
        userEntity.setRegisteredAt(new Date());
        return userMapper.fromEntityToResponse(userRepository.save(userEntity));
    }

    @Override
    public Void updateUser(Long id, UserRequest userRequest) {
        User userEntity = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        BeanUtils.copyProperties(userRequest, userEntity, "id", "registeredAt");
        userRepository.save(userEntity);
        return null;
    }

    @Override
    public Void deleteUser(Long id) {
        userRepository.findById(id).ifPresentOrElse(userRepository::delete, () -> {
            throw new ResponseStatusException(NOT_FOUND);
        });
        return null;
    }
}
