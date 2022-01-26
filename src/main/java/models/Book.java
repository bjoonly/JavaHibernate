package models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Data
@Entity
@Table(name = "tbl_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 250, nullable = false)
    private String name;

    @Column(length = 4000, nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String name, String description, int author_id) {
        this.name = name;
        this.description = description;
        this.author = new Author();
       author.setId(author_id);
    }
}
