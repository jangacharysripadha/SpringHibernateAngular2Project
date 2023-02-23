package com.chary.spring.hibernate.angular.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.chary.spring.hibernate.angular.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public int save(Book book) {

		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	public Book get(int id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	public List<Book> list() {
		List<Book> list=sessionFactory.getCurrentSession().createQuery("from Book").list();
		return list;
	}

	public void update(int id, Book book) {
     
		Session session=sessionFactory.getCurrentSession();
		Book oldBook=(Book) session.byId(Book.class).load(id);
		oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
	    session.flush();
	}

	public void delete(int id) {
     
		Session session=sessionFactory.getCurrentSession();
		Book book=session.byId(Book.class).load(id);
		session.delete(book);
 
	}

}
