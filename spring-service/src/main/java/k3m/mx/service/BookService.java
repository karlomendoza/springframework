package k3m.mx.service;

import java.util.List;

import k3m.mx.entities.Book;

public interface BookService {
	List<Book> findByTitle(String title);
}
