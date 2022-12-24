package task.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import task.restapi.mapper.ProductMapper;
import task.restapi.mapper.TagMapper;
import task.restapi.mapper.request.TagRequest;
import task.restapi.mapper.response.ProductResponse;
import task.restapi.mapper.response.TagResponse;
import task.restapi.entity.Tag;
import task.restapi.repository.TagRepository;
import task.restapi.service.interfaces.TagServiceInterface;

import java.util.List;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TagService implements TagServiceInterface {

    private final TagRepository tagRepository;

    private final TagMapper tagMapper;

    private final ProductMapper productMapper;

    private Tag getTagEntityById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Tag with id " + id + " not found"));
    }

    @Override
    public List<TagResponse> getAllTags() {
        return tagMapper.fromEntitiesToResponseList(tagRepository.findAllByOrderByIdAsc());
    }

    @Override
    public List<TagResponse> getTagsByProductId(Long id) {
        return tagMapper.fromEntitiesToResponseList(tagRepository.);
    }

    @Override
    public TagResponse getTagById(Long id) {
        return tagMapper.fromEntityToResponse(getTagEntityById(id));
    }

    @Override
    public TagResponse createTag(TagRequest tagRequest) {
        Tag tagEntity = tagMapper.fromRequestToEntity(tagRequest);
        if (tagRepository.existsBySlug(tagEntity.getSlug())) {
            throw new ResponseStatusException(FORBIDDEN, "Tag with slug: " + tagEntity.getSlug() + " already exists");
        } else {
            return tagMapper.fromEntityToResponse(tagRepository.save(tagEntity));
        }
    }

    @Override
    public Void updateTag(Long id, TagRequest tagRequest) {
        Tag tagEntity = getTagEntityById(id);
        Tag tagEntityFromRequest = tagMapper.fromRequestToEntity(tagRequest);
        if (!tagEntityFromRequest.getSlug().equals(tagEntity.getSlug()) && tagRepository.existsBySlug(tagEntityFromRequest.getSlug())) {
            throw new ResponseStatusException(FORBIDDEN, "Tag with slug: " + tagEntityFromRequest.getSlug() + " already exists");
        }else {
            BeanUtils.copyProperties(tagEntityFromRequest, tagEntity, "id");
            tagRepository.save(tagEntity);
            return null;
        }
    }

    @Override
    public Void deleteTag(Long id) {
        tagRepository.delete(getTagEntityById(id));
        return null;
    }

    @Override
    public List<ProductResponse> getProductsByTagId(Long id) {
        return productMapper.fromEntitiesToResponseList(getTagEntityById(id).getProducts());
    }
}
