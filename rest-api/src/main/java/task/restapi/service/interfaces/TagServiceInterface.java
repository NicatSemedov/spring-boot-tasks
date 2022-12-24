package task.restapi.service.interfaces;

import task.restapi.mapper.request.TagRequest;
import task.restapi.mapper.response.ProductResponse;
import task.restapi.mapper.response.TagResponse;

import java.util.List;

public interface TagServiceInterface {
    List<TagResponse> getAllTags();

    List<TagResponse> getTagsByProductId(Long id);

    TagResponse getTagById(Long id);

    TagResponse createTag(TagRequest tagResponse);

    Void updateTag(Long id, TagRequest tagResponse);

    Void deleteTag(Long id);

    List<ProductResponse> getProductsByTagId(Long id);
}
