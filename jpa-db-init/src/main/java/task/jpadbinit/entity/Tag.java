package task.jpadbinit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 75, nullable = false)
    private String title;

    @Column(name = "\"metaTitle\"", length = 100)
    private String metaTitle;

    @Column(name="slug", length = 100, nullable = false)
    private String slug;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @ManyToMany(fetch = LAZY, cascade = {PERSIST, MERGE})
    @JoinTable(
            name = "product_tag",
            joinColumns = @JoinColumn(name = "\"tagId\""),
            inverseJoinColumns = @JoinColumn(name = "\"productId\"")
    )
    private Set<Product> products = new HashSet<>();
}
