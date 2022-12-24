package task.restapi.mapper.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {

    private Long id;

    private String title;

    private String slug;

    private String summary;

    private String type;

    private String sku;

    private Float price;

    private Float discount;

    private Integer quantity;

    private String content;
}
