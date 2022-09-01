package com.library.LibraryManagement.controller;

import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.entity.Category;
import com.library.LibraryManagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public Category getACategoryById(@PathVariable long id) {
        return categoryService.getACategoryById(id);
    }

    @PostMapping("/category")
    public void createAuthor(@RequestBody Category category) {
        categoryService.createAuthor(category);
    }

    @PutMapping("/update-category")
    public void updateAuthor(@RequestBody Category category) {
        categoryService.updateAuthor(category);
    }

    @DeleteMapping("/delete-category/{id}")
    public void deleteAuthor(@PathVariable long id) {
        categoryService.deleteAuthor(id);
    }

    @GetMapping("category/getAllBooks/{id}")
    public List<Book> getBooksByCategory(@PathVariable long id) { return categoryService.getBooksByCategory(id); }
}
