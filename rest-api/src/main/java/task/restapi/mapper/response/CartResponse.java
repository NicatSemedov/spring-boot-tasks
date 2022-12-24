package task.restapi.mapper.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartResponse {

    private Long id;

    private Integer status;

    private String firstName;

    private String middleName;

    private String lastName;

    private String mobile;

    private String email;

    private String city;

    private String country;

    private String content;

//    private Date createdAt;

//    private Date updatedAt;

/*
    private UserResponse user;
*/
}
