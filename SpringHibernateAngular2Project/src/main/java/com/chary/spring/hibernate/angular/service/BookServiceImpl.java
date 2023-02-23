package com.chary.spring.hibernate.angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chary.spring.hibernate.angular.dao.BookDao;
import com.chary.spring.hibernate.angular.entity.Book;

@Service
public class BookServiceImpl implements BookService {
    
	@Autowired
	private BookDao bookDao;
	
	@Transactional
	public int save(Book book) {
		
		return bookDao.save(book);
	}
    
	@Transactional
	public Book get(int id) {
		
		return bookDao.get(id);
	}
    
	@Transactional
	public List<Book> list() {
		
		return bookDao.list();
	}
    
	@Transactional
	public void update(int id, Book book) {
		bookDao.update(id, book);

	}
    
	@Transactional
	public void delete(int id) {
		
     bookDao.delete(id);
	}

}
