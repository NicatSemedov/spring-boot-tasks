package task.restapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "tag")
@Data
@NoArgsConstructor
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

    @ManyToMany(cascade = {PERSIST, MERGE}, mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();
}
