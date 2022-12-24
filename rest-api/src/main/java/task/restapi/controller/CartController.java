package task.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.restapi.mapper.request.CartRequest;
import task.restapi.mapper.response.CartResponse;
import task.restapi.service.interfaces.CartServiceInterface;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartServiceInterface cartService;

    @GetMapping
    public ResponseEntity<List<CartResponse>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable Long id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }

    @PostMapping
    public ResponseEntity<CartResponse> saveCart(@RequestBody @Valid CartRequest cartRequest) {
        return ResponseEntity.status(CREATED).body(cartService.saveCart(cartRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCart(@PathVariable("id") Long id, @Valid @RequestBody CartRequest cartRequest) {
        return ResponseEntity.ok(cartService.updateCart(id, cartRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable("id") Long id) {
        return ResponseEntity.status(NO_CONTENT).body(cartService.deleteCart(id));
    }

}
