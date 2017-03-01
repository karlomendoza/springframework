package k3m.mx.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k3m.mx.entities.Book;
import k3m.mx.repository.BookRepository;
import k3m.mx.repository.CategoryRepository;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	@Override
	@Transactional
	public Book findById(String isbn) {
		if(isbn == null || isbn.isEmpty()){
			return null;
		}
		
		Book book;
		try{
			book = bookRepository.getOne(isbn);
			book.getIsbn();
		} catch(EntityNotFoundException ex){
			book = new Book();
			//no entity found return empty object
		}
		return book;
	}
	
	@Override
	@Transactional
	public List<Book> findBooksByIsbns(String isbns) {
		if(isbns == null || isbns.isEmpty()){
			return null;
		}
		List<String> splitIsbns =  Arrays.asList(isbns.split(","));
		
		
		List<Book> books;
		try{
			books = bookRepository.findAll(splitIsbns);
			
		} catch(EntityNotFoundException ex){
			books = new ArrayList<Book>();
			//no entity found return empty object
		}
		return books;
	}

	@Override
	/**
	 * returns 0 if could not delete it, 1 if could delete it
	 */
	public int delete(String isbn) {
		if(isbn == null || isbn.isEmpty()){
			return 0;
		}
		
		bookRepository.delete(isbn);
		return 1;
	}

	@Override
	public void saveOrEdit(Book book) {
		// TODO add validations 
		
		if(book.getCategory() != null && book.getCategory().getIdCategory() != null)
			book.setCategory(categoryRepository.getOne(book.getCategory().getIdCategory()));
		else 
			book.setCategory(null);
		bookRepository.save(book);
		
	}

}
