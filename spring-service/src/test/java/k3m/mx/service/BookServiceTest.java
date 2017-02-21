package k3m.mx.service;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import k3m.mx.config.ServiceContextTest;
import k3m.mx.entities.Book;

public class BookServiceTest extends ServiceContextTest {
	@Test
	public void findByTitle(){
		String titleExpected = "Java";
		List<Book> books = bookService.findByTitle(titleExpected);
		
		books.forEach(book -> {
			String titleActual = book.getTitle();
			System.out.println(titleActual);
			assertThat("title retrived should match title requested", titleExpected, equalToIgnoringCase(titleActual));
		});
	}
}

