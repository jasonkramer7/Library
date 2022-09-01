package com.library.LibraryManagement.repository;

import com.library.LibraryManagement.entity.Category;
import com.library.LibraryManagement.entity.SearchReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    //@Query("select b.name as Book, b.description, a.name as Author, c.name as Category from Book b join books_authors ba on (b.id = ba.book_id) join Author a on (a.id = ba.author_id) join books_categories bc on (b.id = bc.book_id) join Category c on (c.id = bc.category_id) where c.id = 1")

}
