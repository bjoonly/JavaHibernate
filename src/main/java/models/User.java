package models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
@Table(name = "tbl_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 250, nullable = false)
    private String firstName;
    @Column(length = 250, nullable = false)
    private String secondName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Users_Roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;
}