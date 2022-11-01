package task.restapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "\"user\"")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "\"firstName\"", length = 50)
    private String firstName;

    @Column(name = "\"middleName\"", length = 50)
    private String middleName;

    @Column(name = "\"lastName\"", length = 50)
    private String lastName;

    @Column(name = "mobile", length = 15)
    private String mobile;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "\"passwordHash\"", length = 32, nullable = false)
    private String passwordHash;

    @Column(name = "vendor", nullable = false)
    private Boolean vendor;

    @Column(name = "\"registeredAt\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;

    @Column(name = "\"lastLogin\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(name = "intro", columnDefinition = "TEXT")
    private String intro;

    @Column(name = "profile", columnDefinition = "TEXT")
    private String profile;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;
}
