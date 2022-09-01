package com.library.LibraryManagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter @NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(length = 50, nullable = false, unique = true)
    private String isbn;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="author_id")})
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_categories",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")})
    private Set<Category> categories = new HashSet<>();

    public Book(String isbn, String name, String description) {
        this.name = name;
        this.description = description;
        this.isbn = isbn;
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
        author.getBooks().remove(author);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.getBooks().remove(category);
    }

    public void addCategory(Category category) {
        this.categories.add(category);
        category.getBooks().add(this);
    }
}
