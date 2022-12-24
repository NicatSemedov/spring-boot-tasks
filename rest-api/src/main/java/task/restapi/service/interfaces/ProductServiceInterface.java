package task.restapi.service.interfaces;

import task.restapi.mapper.request.ProductRequest;
import task.restapi.mapper.response.ProductResponse;
import task.restapi.mapper.response.TagResponse;

import java.util.List;

public interface ProductServiceInterface {
    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse saveProduct(ProductRequest productRequest);

    Void updateProduct(Long id, ProductRequest productRequest);

    Void deleteProduct(Long id);

    List<TagResponse> getTagsByProductId(Long id);
}
