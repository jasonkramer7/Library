package com.library.LibraryManagement.service;

import com.library.LibraryManagement.entity.Author;
import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.repository.AuthorRepository;
import com.library.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author Not Found"));
    }
    public List<Author> searchAuthor(String search) {
        return authorRepository.searchAuthor(search.toUpperCase());
    }
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author Not Found"));
        authorRepository.deleteById(author.getId());
    }

    public List<Book> getBooksByAuthor(long id){
        List<Book> books = bookRepository.findAll();
        List<Book> returnList = new ArrayList<>();
        for (Book book: books) {
            long newId = book.getAuthors().iterator().next().getId();
            if(newId == id) {
                returnList.add(book);
            }
        }
        return returnList;
    }
}
