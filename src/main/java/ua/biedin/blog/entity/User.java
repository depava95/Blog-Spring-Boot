package ua.biedin.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "users")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "status_id")
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;
    @Column(name = "role_id")
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp create;
    @Column(name = "updated_at")
    @CreationTimestamp
    private Timestamp update;
    @Column(name = "is_deleted")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isDeleted;
    @Column(name = "password")
    private String password;
}
