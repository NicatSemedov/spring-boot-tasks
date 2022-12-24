package task.restapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import task.restapi.mapper.request.ProductRequest;
import task.restapi.mapper.response.ProductResponse;
import task.restapi.entity.Product;
import task.restapi.enums.ProductType;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "startsAt", ignore = true)
    @Mapping(target = "publishedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "endsAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Product fromRequestToEntity(ProductRequest productRequest);

    ProductResponse fromEntityToResponse(Product product);

    List<ProductResponse> fromEntitiesToResponseList(List<Product> products);

    default ProductType fromIntegerToProductType(Integer type) {
        return ProductType.fromInteger(type);
    }

    List<ProductResponse> fromEntitiesToResponseList(Set<Product> products);
}
