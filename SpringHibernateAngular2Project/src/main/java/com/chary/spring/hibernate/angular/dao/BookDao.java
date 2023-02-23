package com.chary.spring.hibernate.angular.dao;

import java.util.List;

import com.chary.spring.hibernate.angular.entity.Book;

public interface BookDao {
	
	public int save(Book book);
	public Book get(int id);
	public List<Book> list();
	public void update(int id,Book book);
	public void delete(int id);


}
