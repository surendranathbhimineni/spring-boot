package com.surendra.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.surendra.dao.BookCategory;

/**
 * @author Bhiminenis
 *
 */
@Repository
public interface BookCategoryRepository extends CrudRepository<BookCategory, Integer> {

	List<BookCategory> findByName(String name);
	BookCategory findById(int id);

}
