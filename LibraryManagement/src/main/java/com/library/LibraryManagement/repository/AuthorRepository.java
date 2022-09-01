package com.library.LibraryManagement.repository;

import com.library.LibraryManagement.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE UPPER(a.name) LIKE %?1%")
    List<Author> searchAuthor(String search);
}
