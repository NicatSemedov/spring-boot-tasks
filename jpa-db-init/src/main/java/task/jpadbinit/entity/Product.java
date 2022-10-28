package task.jpadbinit.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "\"userId\"")
    private User user;

    @Column(name = "title", length = 75, nullable = false)
    private String title;

    @Column(name = "\"metaTitle\"", length = 100)
    private String metaTitle;

    @Column(name="slug", length = 100, nullable = false)
    private String slug;

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "type", columnDefinition = "SMALLINT", nullable = false)
    private Integer type;

    @Column(name = "sku", length = 100, nullable = false)
    private String sku;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "discount", nullable = false)
    private Float discount;

    @Column(name = "quantity", columnDefinition = "SMALLINT", nullable = false)
    private Integer quantity;

    @Column(name = "shop", nullable = false)
    private Boolean shop;

    @CreationTimestamp
    @Column(name = "\"createdAt\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "\"updatedAt\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "\"publishedAt\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedAt;

    @Column(name = "\"startsAt\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startsAt;

    @Column(name = "\"endsAt\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endsAt;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @ManyToMany(fetch = LAZY, cascade = {PERSIST, MERGE}, mappedBy = "products")
    private Set<Tag> tags = new HashSet<>();
}
