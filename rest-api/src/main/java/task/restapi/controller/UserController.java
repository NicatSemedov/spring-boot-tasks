package task.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.restapi.mapper.request.UserRequest;
import task.restapi.mapper.response.CartResponse;
import task.restapi.mapper.response.ProductResponse;
import task.restapi.mapper.response.UserResponse;
import task.restapi.service.interfaces.UserServiceInterface;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserServiceInterface userService;

    @GetMapping
    ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.status(CREATED).body(userService.saveUser(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.updateUser(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        return ResponseEntity.status(NO_CONTENT).body(userService.deleteUser(id));
    }

    @GetMapping("/{id}/carts")
    public ResponseEntity<List<CartResponse>> getUserCarts(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserCarts(id));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<ProductResponse>> getUserProducts(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserProducts(id));
    }
}
