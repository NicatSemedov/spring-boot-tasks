package task.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.restapi.mapper.request.TagRequest;
import task.restapi.mapper.response.ProductResponse;
import task.restapi.mapper.response.TagResponse;
import task.restapi.service.interfaces.TagServiceInterface;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    private final TagServiceInterface tagService;

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagResponse> getTagById(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.getTagById(id));
    }

    @PostMapping
    public ResponseEntity<TagResponse> createTag(@RequestBody @Valid TagRequest tagRequest) {
        return ResponseEntity.ok(tagService.createTag(tagRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTag(@PathVariable Long id, @RequestBody @Valid TagRequest tagRequest) {
        return ResponseEntity.ok(tagService.updateTag(id, tagRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.deleteTag(id));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<ProductResponse>> getProductsByTagId(@PathVariable Long id){
        return ResponseEntity.ok(tagService.getProductsByTagId(id));
    }
}
