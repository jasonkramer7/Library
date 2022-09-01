package com.library.LibraryManagement.service;

import com.library.LibraryManagement.entity.Author;
import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
    }

    public List<Book> searchBook(String search) {
        return bookRepository.searchBook(search.toUpperCase());
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
        bookRepository.deleteById(book.getId());
    }
}
