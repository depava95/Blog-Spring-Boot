package ua.biedin.blog.repository.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "is_deleted")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isDeleted;

//    @ManyToMany(mappedBy = "tag", fetch = FetchType.EAGER)
//    private Set<Article> articles = new HashSet<>();
}
