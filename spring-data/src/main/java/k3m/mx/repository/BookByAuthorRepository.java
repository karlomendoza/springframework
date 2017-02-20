package k3m.mx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import k3m.mx.link.BookByAuthor;
import k3m.mx.link.BookByAuthor.PK;

public interface BookByAuthorRepository extends JpaRepository<BookByAuthor, PK> {

}
