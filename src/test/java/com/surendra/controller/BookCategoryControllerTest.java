package com.surendra.controller;

import com.surendra.controller.BookCategoryController;
import com.surendra.dao.BookCategory;
import com.surendra.dao.repository.BookCategoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookCategoryControllerTest {

	@InjectMocks
	BookCategoryController test;

	@Mock
	BookCategoryRepository bookCategoryRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAll() {
		List<BookCategory> bookCategoryList = new ArrayList<BookCategory>() {
			private static final long serialVersionUID = 1552736291031846070L;

			{
				add(new BookCategory());
				add(new BookCategory());
			}
		};
		when(bookCategoryRepository.findAll()).thenReturn(bookCategoryList);

		Assert.assertEquals(2, test.getAll().size());
	}
}