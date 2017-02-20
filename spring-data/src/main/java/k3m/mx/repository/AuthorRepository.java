package k3m.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import k3m.mx.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	public List<Author> findByFirstName(String firstName);
}
