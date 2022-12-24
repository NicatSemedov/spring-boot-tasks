package task.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import task.restapi.mapper.ProductMapper;
import task.restapi.mapper.TagMapper;
import task.restapi.mapper.request.ProductRequest;
import task.restapi.mapper.response.ProductResponse;
import task.restapi.mapper.response.TagResponse;
import task.restapi.entity.Product;
import task.restapi.repository.ProductRepository;
import task.restapi.service.interfaces.ProductServiceInterface;
import task.restapi.service.interfaces.TagServiceInterface;
import task.restapi.service.interfaces.UserServiceInterface;

import java.util.List;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceInterface {

    private final ProductRepository productRepository;

    private final UserServiceInterface userService;

    private final TagServiceInterface tagService;

    private final ProductMapper productMapper;

    private final TagMapper tagMapper;

    private Product getProductEntityById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Product not found with id: " + id));
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productMapper.fromEntitiesToResponseList(productRepository.findAllByOrderByIdAsc());
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productMapper.fromEntityToResponse(getProductEntityById(id));
    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {
        userService.getUserEntityById(productRequest.getUserId());//check user exists
        Product product = productMapper.fromRequestToEntity(productRequest);
        if (productRepository.existsBySlug(product.getSlug())) {
            throw new ResponseStatusException(FORBIDDEN, "Product with slug: " + product.getSlug() + " already exists");
        }else {
            return productMapper.fromEntityToResponse(productRepository.save(product));
        }
    }

    @Override
    public Void updateProduct(Long id, ProductRequest productRequest) {
        Product product = getProductEntityById(id);
        userService.getUserEntityById(productRequest.getUserId());//check user exists
        Product productFromRequest = productMapper.fromRequestToEntity(productRequest);
        if (!productFromRequest.getSlug().equals(product.getSlug()) && productRepository.existsBySlug(productFromRequest.getSlug())) {
            throw new ResponseStatusException(FORBIDDEN, "Product with slug: " + productFromRequest.getSlug() + " already exists");
        }else {
            BeanUtils.copyProperties(productFromRequest, product, "id", "createdAt");
            productRepository.save(product);
            return null;
        }
    }

    @Override
    public Void deleteProduct(Long id) {
        productRepository.delete(getProductEntityById(id));
        return null;
    }

    @Override
    public List<TagResponse> getTagsByProductId(Long id) {
        return tagService.getTagsByProductId(id);
    }
}
