package task.restapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import task.restapi.mapper.request.TagRequest;
import task.restapi.mapper.response.TagResponse;
import task.restapi.entity.Tag;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface TagMapper {

    @Mapping(target = "id", ignore = true)
    /*@Mapping(target = "slug", ignore = true)*/
    @Mapping(target = "products", ignore = true)
    Tag fromRequestToEntity(TagRequest tagRequest);

    TagResponse fromEntityToResponse(Tag tag);

    List<TagResponse> fromEntitiesToResponseList(List<Tag> tags);

    List<TagResponse> fromEntitiesToResponseList(Set<Tag> tags);
}
