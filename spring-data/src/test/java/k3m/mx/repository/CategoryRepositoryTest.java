package k3m.mx.repository;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import k3m.mx.context.PersistenceContextTest;
import k3m.mx.entities.Category;

public class CategoryRepositoryTest extends PersistenceContextTest {

	@Test
	public void count() {

		long numberCategory = categoryRepository.count();
		Assert.assertTrue(numberCategory > 0);
	}

	@Test
	public void findAllCategories() {
		List<Category> categorys = categoryRepository.findAll();
		Assert.assertFalse(categorys.isEmpty());
	}

	@Test
	public void findByName() {
		String nameExpected = "novel";
		List<Category> categorys = categoryRepository.findByName(nameExpected);
		String nameActual = categorys.get(0).getName();
		Assert.assertTrue(nameActual.contains(nameExpected));
	}
}