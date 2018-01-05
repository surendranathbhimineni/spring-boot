package com.surendra.dao;

import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "book_category")
@Data
public class BookCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Book> books;
}