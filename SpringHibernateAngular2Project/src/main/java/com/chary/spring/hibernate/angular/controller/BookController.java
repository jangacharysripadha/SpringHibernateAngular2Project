package com.chary.spring.hibernate.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chary.spring.hibernate.angular.entity.Book;
import com.chary.spring.hibernate.angular.service.BookService;

@CrossOrigin("*")
@RestController
public class BookController {
    
	@Autowired
	private BookService bookService;
	
	@PostMapping("/api/book")
	public ResponseEntity<?> save(@RequestBody Book book)
	{
		int id=bookService.save(book);
		return ResponseEntity.ok().body("Book created with id:"+id);
	}
	
	@GetMapping("/api/book")
	public ResponseEntity<List<Book>> list()
	{
	List<Book> list=bookService.list();
	return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping("/api/book/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") int id)
	{
		Book book=bookService.get(id);
		return ResponseEntity.ok().body(book);
	}
	
	@PutMapping("/api/book/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Book book)
	{
		bookService.update(id, book);
		return ResponseEntity.ok().body("Book has been updated");
		
	}
	
	@DeleteMapping("/api/book/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id)
	{
		bookService.delete(id);
		return ResponseEntity.ok().body("Book has been deleted");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
