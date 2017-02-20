package k3m.mx.repository;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.transaction.annotation.Transactional;

import k3m.mx.context.PersistenceContextTest;
import k3m.mx.entities.Book;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookRepositoryTest extends PersistenceContextTest {

	@Test
	@Transactional
	public void aCreate(){
		Book bookExpected = new Book("bbb", "lo que el viento se dejo", new Date());
		bookRepository.saveAndFlush(bookExpected);
		
		Book bookActual = bookRepository.getOne("bbb");
		
		assertThat("the books names are different, should be the same", 
				bookExpected.getTitle(), equalTo(bookActual.getTitle()));
	}

	@Test
	public void count() {

		long numberBooks = bookRepository.count();
		assertThat("there should be atleast one book", numberBooks,  greaterThan(0L));
	}

	@Test
	public void findAllBooks() {
		List<Book> books = bookRepository.findAll();
		assertThat("this should not be empty", books, is(not(empty())));
	}

	@Test
	public void findByTitle() {
		String titleExpected = "java";
		List<Book> books = bookRepository.findByTitle(titleExpected);
		String titleActual = books.get(0).getTitle();
		assertThat("titles should be the same", titleActual, equalTo(titleExpected));
	}
}