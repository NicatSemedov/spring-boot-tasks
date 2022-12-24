package task.restapi.mapper.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagResponse {

    private Long id;

    private String title;

    private String slug;

    private String content;
}
