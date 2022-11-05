package task.restapi.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import task.restapi.dto.request.CartRequest;
import task.restapi.dto.response.CartResponse;
import task.restapi.entity.Cart;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "user.id", source = "userId")
    Cart fromRequestToEntity(CartRequest cartRequest);

    CartResponse fromEntityToResponse(Cart cart);

    List<CartResponse> fromEntitiesToResponseList(List<Cart> carts);
}
