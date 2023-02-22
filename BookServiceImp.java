package com.student.student.MongoDBServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student.MongoDBModel.Book;
import com.student.student.MongoDBRepository.BookRepository;
import com.student.student.MongoDBService.BookService;

@Service
public class BookServiceImp implements BookService {

	@Autowired
	BookRepository bookRep;

	@Override
	public Book saveBook(Book book) {

		return bookRep.save(book);
	}

	@Override
	public List<Book> findAllBook() {

		return bookRep.findAll();
	}

	@Override
	public Book updateBook(Book book, Integer id) {
		Book newbook = bookRep.findById(id).get();
		
		newbook.setId(book.getId());
		newbook.setAuthorName(book.getAuthorName());
		newbook.setBookName(book.getBookName());
		newbook.setCost(book.getCost());

		return bookRep.save(newbook);
	}

	
	@Override
	public void deleteBookById(Integer id) {

		bookRep.deleteById(id);
	}

	@Override
	public Book getBook(Integer id) {
		
		return bookRep.findById(id).get();
	}

	@Override
	public Book updateBook(Book book) {
		
		return bookRep.save(book);
	}

	
}
