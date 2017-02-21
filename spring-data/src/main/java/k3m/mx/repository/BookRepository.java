package k3m.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import k3m.mx.entities.Book;

public interface BookRepository extends JpaRepository<Book, String> {
	public List<Book> findByTitle(String title);
}
