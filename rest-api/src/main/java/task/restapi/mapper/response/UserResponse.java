package task.restapi.mapper.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String mobile;

    private String email;

    private Boolean vendor;

    private String intro;

    private String profile;
}
