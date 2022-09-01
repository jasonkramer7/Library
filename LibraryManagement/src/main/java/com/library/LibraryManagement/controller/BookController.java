package com.library.LibraryManagement.controller;

import com.library.LibraryManagement.entity.Author;
import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.entity.Everything;
import com.library.LibraryManagement.service.AuthorService;
import com.library.LibraryManagement.service.BookService;
import com.library.LibraryManagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/book")
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }

    @GetMapping("/book/search/{search}")
    public List<Book> searchBook(@PathVariable String search) {
        return bookService.searchBook(search);
    }

    @PutMapping("/update-book")
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/remove-book/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/getAll")
    public Everything getEverything(){
        Everything allOfIt = new Everything();
        allOfIt.setBooks(bookService.getAllBooks());
        allOfIt.setAuthors(authorService.getAllAuthors());
        allOfIt.setCategories(categoryService.getAllCategories());
        return allOfIt;
    }
}
