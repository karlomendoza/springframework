package k3m.mx.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k3m.mx.entities.Category;
import k3m.mx.repository.CategoryRepository;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional
	public Category findById(Integer idCategory) {
		if(idCategory == null || idCategory == 0)
			return null;
		
		
		Category category;
		try{
			category = categoryRepository.getOne(idCategory);
			category.getIdCategory();
		} catch(EntityNotFoundException ex){
			category = new Category();
			//no entity found return empty object
		}
		return category;
	}

	@Override
	/**
	 * returns 1 if could delete it, 0 if not
	 */
	public int delete(Integer idCategory) {
		if(idCategory == null || idCategory == 0)
			return 0;
		categoryRepository.delete(idCategory);
		return 1;
	}

	@Override
	public void saveOrEdit(Category category) {
		categoryRepository.save(category);
	}

}
