package ua.biedin.blog.entity;

import lombok.Data;

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
