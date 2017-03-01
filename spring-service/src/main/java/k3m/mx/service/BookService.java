package k3m.mx.service;

import java.util.List;

import k3m.mx.entities.Book;

public interface BookService {
	List<Book> findByTitle(String title);
	
	public Book findById(String isbn);
	
	public int delete(String isbn);
	
	public void saveOrEdit(Book book);

	List<Book> findBooksByIsbns(String isbns);
}
