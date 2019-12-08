package ua.biedin.blog.repository.entity;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "articles_categories")
public class Categories {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String articleName;
}
