package com.library.LibraryManagement;

import com.library.LibraryManagement.entity.Author;
import com.library.LibraryManagement.entity.Book;
import com.library.LibraryManagement.entity.Category;
import com.library.LibraryManagement.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Flow;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return(args) -> {
			Book book1 = new Book("ABC", "Book name", "My first book");
			Author author1 = new Author("Test name1", "Test description");
			Category category1 = new Category("Business books");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			bookService.createBook(book1);

			Book book2 = new Book("ABC1", "Book name", "My first book");
			Author author2 = new Author("Test name2", "Test description");
			Category category2 = new Category("Science books");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			bookService.createBook(book2);

			Book book3 = new Book("ABC21", "Book name", "My first book");
			Author author3 = new Author("Test name3", "Test description");
			Category category3 = new Category("Fiction books");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			bookService.createBook(book3);
		};
	}

}
