package ua.biedin.blog.repository.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "articles")
public class Article {

    @Id
    @Column(name = "id", columnDefinition = "INT(11)")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories categories;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;
    @Column(name = "status_id")
    @Enumerated(EnumType.ORDINAL)
    private ArticleStatus status;
    @Column(name = "is_deleted")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isDeleted;
    @Column(name = "created_at")
    private Timestamp create;
    @Column(name = "updated_at")
    private Timestamp update;
    @Column(name = "rating", columnDefinition = "INT(11)")
    private Integer rating;

    @ManyToMany(mappedBy = "articles")
    private Set<Tag> tags = new HashSet<>();
}
