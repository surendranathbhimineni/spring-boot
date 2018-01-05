package com.surendra.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.surendra.dao.Book;


/**
 * @author Bhiminenis
 *
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	
	Book findById(int id);
	
}
