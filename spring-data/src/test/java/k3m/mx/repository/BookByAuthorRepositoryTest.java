package k3m.mx.repository;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import k3m.mx.context.PersistenceContextTest;
import k3m.mx.link.BookByAuthor;
import k3m.mx.link.BookByAuthor.PK;

public class BookByAuthorRepositoryTest extends PersistenceContextTest {

	@Test
	public void count() {

		long numberCategory = bookByAuthorRepository.count();
		assertThat("there should be atleast one category", numberCategory,  greaterThanOrEqualTo(0L));
	}

	@Test
	public void findAllCategories() {
		List<BookByAuthor> categorys = bookByAuthorRepository.findAll();
		assertThat("this should not be empty", categorys, is(not(empty())));
	}

	@Test
	@Transactional
	public void findByPrimaryKey() {
		PK pk = new BookByAuthor.PK();
		
		int authorExpected = 1;
		
		pk.setIdAuthor(authorExpected);
		pk.setIsbn("aaa");
		
		BookByAuthor bookByAuthor = bookByAuthorRepository.getOne(pk);
		int authorActual = bookByAuthor.getPk().getIdAuthor();
		assertThat("author Id should be the same", authorActual, equalTo(authorExpected));
	}
}