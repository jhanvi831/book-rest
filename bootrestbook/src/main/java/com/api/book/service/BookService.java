package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Service
public class BookService {//DAO layer
	
	@Autowired
	private BookRepository bookRepository;
	
	
	//private static List<Book> list = new ArrayList<>();
	
//	static {
//		list.add(new Book(2, "The hunger games", "Suzanne Collins"));
//		list.add(new Book(3, "Harry Potter", "J.K Rowling"));
//		list.add(new Book(4, "Suheldev", "Amish Tripathy"));
//	}
	
	//get all books
	public List<Book> getAllBooks(){
		List<Book> list =(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Book getById(int id) {
		//stream API
		Book book=null;
		try {
//			book=list.stream()
//					.filter(e->e.getId()==id)
//					.findFirst()
//					.get();
			
			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//adding the book
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}
	
	//delete a book
	public void deleteBook(int bid) {
		
		bookRepository.deleteById(bid);
//		list = list.stream().filter(e->{
//		if(e.getId()!=bid) {
//			return true;
//		}
//		return false;
//		}).collect(Collectors.toList());
	}

	//update the book
	public void updateBook(Book book, int bookId) {
//		list = list.stream().map(b-> {
//			if(b.getId()==bookId){
//			b.setTitle(book.getTitle());
//			b.setAuthor(book.getAuthor());
//			}
//			return b;
//		})
//		.collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepository.save(book);
		
	}
	//comments are mostly fake services 
	//controller remains as it is
	
}
 