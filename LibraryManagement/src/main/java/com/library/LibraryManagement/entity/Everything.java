package com.library.LibraryManagement.entity;

import com.library.LibraryManagement.entity.Author;
import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@Getter @Setter @NoArgsConstructor
public class Everything {

    List<Book> books = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    List<Author> authors = new ArrayList<>();

}
