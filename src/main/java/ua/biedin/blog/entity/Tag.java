package ua.biedin.blog.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
