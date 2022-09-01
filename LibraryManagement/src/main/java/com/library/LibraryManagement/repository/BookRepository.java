package com.library.LibraryManagement.repository;

import com.library.LibraryManagement.entity.Author;
import com.library.LibraryManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE UPPER(b.name) LIKE %?1%")
    List<Book> searchBook(String search);

}
