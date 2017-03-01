package k3m.mx.service;

import k3m.mx.entities.Category;

public interface CategoryService {
	public Category findById(Integer idCategory);
	
	public int delete(Integer idCategory);
	
	public void saveOrEdit(Category category);
}
