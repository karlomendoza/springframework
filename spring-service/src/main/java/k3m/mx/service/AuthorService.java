package k3m.mx.service;

import k3m.mx.entities.Author;

public interface AuthorService {
	public Author findById(Integer authorId);
	
	public int delete(Integer authorId);
	
	public void saveOrEdit(Author author);

	Author findByIdNotLazy(Integer authorId);
}
