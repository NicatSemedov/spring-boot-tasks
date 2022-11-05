package task.restapi.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import task.restapi.validation.NullOrNotBlank;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CartRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Integer status;

    @NotBlank
    private String firstName;

    @NullOrNotBlank
    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String mobile;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @NotBlank
    private String content;
}
