package com.surendra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.surendra.dao.Book;
import com.surendra.dao.BookCategory;
import com.surendra.dao.repository.BookCategoryRepository;
import com.surendra.dao.repository.BookRepository;

@SpringBootApplication
@EnableCaching
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCategoryRepository bookCategoryRepository;

	@Autowired
	public String init() {
		BookCategory categoryA = new BookCategory();
		categoryA.setName("Category A");
		categoryA.setId(1);
		List<Book> bookAs = new ArrayList<Book>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Book("Book A5", categoryA));
				add(new Book("Book A7", categoryA));
				add(new Book("Book A11", categoryA));
				add(new Book("Book A1", categoryA));
				add(new Book("Book A3", categoryA));
				add(new Book("Book A4", categoryA));
				add(new Book("Book A8", categoryA));
				add(new Book("Book A10", categoryA));
				add(new Book("Book A6", categoryA));
				add(new Book("Book A12", categoryA));
				add(new Book("Book A2", categoryA));
				add(new Book("Book A9", categoryA));
			}
		};
		categoryA.setBooks(bookAs);
		bookCategoryRepository.save(categoryA);
		System.out.println("===================================================================================");
		System.out.println("===Initialized==Initialized==Initialized==Initialized==Initialized==Initialized====");
		System.out.println("===================================================================================");

		System.out.println(bookAs);

		Collections.sort(bookAs);
		System.out.println("After sorting");

		System.out.println(bookAs);

		return "";
	}

}
