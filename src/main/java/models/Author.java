package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastName;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstName;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Book> books;

    public Author() {
        books = new ArrayList<Book>();
    }

    public Author(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        books = new ArrayList<Book>();
    }
}

