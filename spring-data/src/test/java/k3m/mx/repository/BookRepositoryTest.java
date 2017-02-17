package k3m.mx.repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.Assert;
import k3m.mx.context.PersistenceContextTest;
import k3m.mx.entities.Book;

public class BookRepositoryTest extends PersistenceContextTest {

	@Test
	public void count() {

		long numberBooks = bookRepository.count();
		Assert.assertTrue(numberBooks > 0);
	}

	@Test
	public void findAllBooks() {
		List<Book> books = bookRepository.findAll();
		Assert.assertFalse(books.isEmpty());
	}

	@Test
	public void findByTitle() {
		String titleExpected = "Java";
		List<Book> books = bookRepository.findByTitle(titleExpected);
		String titleActual = books.get(0).getTitle();
		Assert.assertTrue(titleActual.contains(titleExpected));
	}
}