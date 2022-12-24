package task.restapi.mapper.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ProductRequest {

    @NotNull
    private Long userId;

    @NotBlank
    private String title;

    @NotBlank
    private String slug;

    private String metaTitle;

    private String summary;

    @NotNull
    @Min(value = 1) @Max(value = 4)
    private Integer type;

    @NotBlank
    private String sku;

    @NotNull
    private Float price;

    @NotNull
    private Float discount;

    @NotNull
    private Integer quantity;

    @NotNull
    private Boolean shop;

    private String content;

    private Set<TagRequest> tags = new HashSet<>();
}
