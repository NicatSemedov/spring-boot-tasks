package task.restapi.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import task.restapi.validation.NullOrNotBlank;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserRequest implements Serializable {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 16)
    private String firstName;

    @NullOrNotBlank
    @Size(min = 3, max = 16)
    private String middleName;

    @NotBlank
    @Size(min = 3, max = 16)
    private String lastName;

    @NotBlank
    private String mobile;

    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 32)
    private String password;

    @NotNull
    private Boolean vendor;

    @NotBlank
    private String intro;

    @NotBlank
    private String profile;
}
