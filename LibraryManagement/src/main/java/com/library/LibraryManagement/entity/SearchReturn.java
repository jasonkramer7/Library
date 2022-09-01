package com.library.LibraryManagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
@NoArgsConstructor
public class SearchReturn {
    String book;
    String description;
    String author;
    String category;
}
