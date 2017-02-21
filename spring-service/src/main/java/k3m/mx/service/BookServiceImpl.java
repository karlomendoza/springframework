package k3m.mx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import k3m.mx.entities.Book;
import k3m.mx.repository.BookRepository;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

}
