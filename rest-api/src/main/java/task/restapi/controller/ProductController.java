package task.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.restapi.mapper.request.ProductRequest;
import task.restapi.mapper.response.ProductResponse;
import task.restapi.mapper.response.TagResponse;
import task.restapi.service.interfaces.ProductServiceInterface;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceInterface productService;

    @GetMapping
    ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    ResponseEntity<ProductResponse> saveProduct(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.ok(productService.saveProduct(productRequest));
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.ok(productService.updateProduct(id, productRequest));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/{id}/tags")
    ResponseEntity<List<TagResponse>> getTagsByProductId(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getTagsByProductId(id));
    }
}
