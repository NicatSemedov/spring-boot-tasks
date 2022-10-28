package task.jpadbinit.entity;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 75)
    private String title;

    @Column(name = "\"metaTitle\"", length = 100)
    private String metaTitle;

    @Column(name="slug", length = 100)
    private String slug;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
}
