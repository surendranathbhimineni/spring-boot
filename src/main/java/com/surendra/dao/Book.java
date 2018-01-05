package com.surendra.dao;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = { "id", "name" })
@ToString(of = { "id", "name" })
public class Book implements Comparable<Book> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "book_category_id")
	@JsonIgnore
	private BookCategory bookCategory;

	public Book(String name, BookCategory bookCategory) {
		super();
		this.name = name;
		this.bookCategory = bookCategory;
	}

	@Override
	public int compareTo(Book o) {
		return getName().compareTo(o.getName());
	}

}