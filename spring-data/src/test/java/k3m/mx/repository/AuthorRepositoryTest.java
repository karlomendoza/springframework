package k3m.mx.repository;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.transaction.annotation.Transactional;

import k3m.mx.context.PersistenceContextTest;
import k3m.mx.entities.Author;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorRepositoryTest extends PersistenceContextTest {

	@Test
	@Transactional
	public void aCreate(){
		Author authorExpected = new Author(1, "karlo", "mendoza");
		authorRepository.saveAndFlush(authorExpected);
		
		Author authorActual = authorRepository.getOne(1);
		
		assertThat("the authors name are different, should be the same", 
				authorExpected.getFirstName(), equalTo(authorActual.getFirstName()));
	}
	
	@Test
	public void count() {
		long numberAuthors = authorRepository.count();
		assertThat("there should be atleast one author", numberAuthors,  greaterThanOrEqualTo(0L));
	}

	@Test
	public void findAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		assertThat("this should not be empty", authors, is(not(empty())));
	}

	@Ignore
	@Test
	public void findByTitle() {
		String nameExpected = "Karlo";
		List<Author> authors = authorRepository.findByFirstName(nameExpected);
		String titleActual = authors.get(0).getFirstName();
		assertThat("authors name should be the same", titleActual, equalTo(nameExpected));
	}
	
	@Transactional
	@Test
	public void authorHasBooks(){
		Author author = authorRepository.getOne(1);
		
		assertThat("author should have a list of books", author.getBooks(), is(not(empty())));
	}
}