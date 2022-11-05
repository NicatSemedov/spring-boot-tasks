package task.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import task.restapi.dto.mapper.CartMapper;
import task.restapi.dto.request.CartRequest;
import task.restapi.dto.response.CartResponse;
import task.restapi.entity.Cart;
import task.restapi.repository.CartRepository;
import task.restapi.service.interfaces.CartServiceInterface;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CartService implements CartServiceInterface {

    private final CartRepository cartRepository;

    private final CartMapper cartMapper;

    @Override
    public List<CartResponse> getAllCarts() {
        return cartMapper.fromEntitiesToResponseList(cartRepository.findAllByOrderByIdAsc());
    }

    public Cart getCartEntityById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cart not found with id: " + id));
    }

    @Override
    public CartResponse getCartById(Long id) {
        return cartMapper.fromEntityToResponse(getCartEntityById(id));
    }

    @Override
    public CartResponse saveCart(CartRequest cartRequest) {
        Cart cartEntity = cartMapper.fromRequestToEntity(cartRequest);
        return cartMapper.fromEntityToResponse(cartRepository.save(cartEntity));
    }

    @Override
    public Void updateCart(Long id, CartRequest cartRequest) {
        Cart cartEntity = getCartEntityById(id);
        Cart cartFromRequest = cartMapper.fromRequestToEntity(cartRequest);
        BeanUtils.copyProperties(cartFromRequest, cartEntity, "id", "createdAt");
        cartRepository.save(cartEntity);
        return null;
    }

    @Override
    public Void deleteCart(Long id) {
        cartRepository.delete(getCartEntityById(id));
        return null;
    }
}

