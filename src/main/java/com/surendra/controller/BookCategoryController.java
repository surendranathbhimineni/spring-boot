package com.surendra.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.surendra.dao.BookCategory;
import com.surendra.dao.repository.BookCategoryRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/BookCategory")
@Api(tags = { "Book Category" })
public class BookCategoryController {
	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public @ResponseBody List<BookCategory> getAll() {
		List<BookCategory> bookCategoryList = new ArrayList<>();
		for (BookCategory iterable : bookCategoryRepository.findAll()) {
			bookCategoryList.add(iterable);
		}
		bookCategoryList.stream().forEach(a -> Collections.sort(a.getBooks()));
		return bookCategoryList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Cacheable(cacheNames = "BookCategoryCache", key = "#id")
	public @ResponseBody BookCategory getById(@PathVariable("id") int id) {
		return bookCategoryRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@CachePut(cacheNames = "BookCategoryCache", key = "#bookCategory.id")
	public @ResponseBody BookCategory update(@RequestBody BookCategory bookCategory) {
		return bookCategoryRepository.save(bookCategory);
	}

	@RequestMapping(method = RequestMethod.POST)
	@CachePut(cacheNames = "BookCategoryCache", key = "#bookCategory.id")
	public @ResponseBody BookCategory insert(@RequestBody BookCategory bookCategory) {
		if (bookCategory.getId() > 0) {
			return null;
		}
		return bookCategoryRepository.save(bookCategory);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@CacheEvict(cacheNames = "BookCategoryCache", key = "#id")
	public @ResponseBody void delete(@PathVariable("id") int id) {
		bookCategoryRepository.delete(id);
	}
}