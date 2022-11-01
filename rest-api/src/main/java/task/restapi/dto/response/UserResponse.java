package task.restapi.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserResponse implements Serializable {

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
