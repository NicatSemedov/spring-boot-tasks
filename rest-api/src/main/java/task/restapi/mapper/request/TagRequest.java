package task.restapi.mapper.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class TagRequest {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String slug;

    private String metaTitle;

    private String content;
}
