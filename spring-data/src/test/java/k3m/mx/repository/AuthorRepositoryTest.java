package k3m.mx.repository;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import k3m.mx.context.PersistenceContextTest;
import k3m.mx.entities.Author;

public class AuthorRepositoryTest extends PersistenceContextTest {

	@Test
	public void count() {

		long numberAuthors = authorRepository.count();
		Assert.assertTrue(numberAuthors > 0);
	}

	@Test
	public void findAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		Assert.assertFalse(authors.isEmpty());
	}

	@Ignore
	@Test
	public void findByTitle() {
		String nameExpected = "Karlo";
		List<Author> authors = authorRepository.findByFirstName(nameExpected);
		String titleActual = authors.get(0).getFirstName();
		Assert.assertTrue(titleActual.contains(nameExpected));
	}
}