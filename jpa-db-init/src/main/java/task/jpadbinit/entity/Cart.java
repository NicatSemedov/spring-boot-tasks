package task.jpadbinit.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "\"userId\"")
    private User user;

    @Column(name = "status", columnDefinition = "SMALLINT", nullable = false)
    private Integer status;

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

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    @Column(name = "\"createdAt\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "\"updatedAt\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
