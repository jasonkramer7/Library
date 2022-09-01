package com.library.LibraryManagement.controller;

import com.library.LibraryManagement.entity.Author;
import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author/search/{search}")
    public List<Author> searchAuthor(@PathVariable String search) {
        return authorService.searchAuthor(search);
    }

    @PostMapping("/author")
    public void createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
    }

    @PutMapping("/update-author")
    public void updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);
    }

    @DeleteMapping("/delete-author/{id}")
    public void deleteAuthor(@PathVariable long id) {
        authorService.deleteAuthor(id);
    }

    @GetMapping("author/getAllBooks/{id}")
    public List<Book> getBooksByAuthor(@PathVariable long id) { return authorService.getBooksByAuthor(id); }

}
