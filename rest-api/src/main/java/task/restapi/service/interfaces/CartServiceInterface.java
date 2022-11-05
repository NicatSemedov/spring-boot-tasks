package task.restapi.service.interfaces;

import task.restapi.dto.request.CartRequest;
import task.restapi.dto.response.CartResponse;

import java.util.List;

public interface CartServiceInterface {

    List<CartResponse> getAllCarts();

    CartResponse getCartById(Long id);

    CartResponse saveCart(CartRequest cartRequest);

    Void updateCart(Long id, CartRequest cartRequest);

    Void deleteCart(Long id);
}
