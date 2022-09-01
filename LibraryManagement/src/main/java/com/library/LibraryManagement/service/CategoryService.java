package com.library.LibraryManagement.service;

import com.library.LibraryManagement.entity.Author;
import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.entity.Category;
import com.library.LibraryManagement.repository.AuthorRepository;
import com.library.LibraryManagement.repository.BookRepository;
import com.library.LibraryManagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getACategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found"));
    }

    public void createAuthor(Category category) {
        categoryRepository.save(category);
    }

    public void updateAuthor(Category category) {
        categoryRepository.save(category);
    }

    public void deleteAuthor(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found"));
        categoryRepository.deleteById(category.getId());
    }

    public List<Book> getBooksByCategory(long id){
        List<Book> books = bookRepository.findAll();
        List<Book> returnList = new ArrayList<>();
        for (Book book: books) {
            long newId = book.getCategories().iterator().next().getId();
            if(newId == id) {
                returnList.add(book);
            }
        }
        return returnList;
    }
}
