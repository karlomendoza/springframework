package k3m.mx.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k3m.mx.entities.Author;
import k3m.mx.repository.AuthorRepository;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	List<String> asd = new ArrayList<>();
	
	@Override
	@Transactional
	public Author findById(Integer authorId) {
		
		if(authorId == null || authorId == 0){
			return null;
		}
		Author author;
		try{
			author = authorRepository.getOne(authorId);
			author.getIdAuthor();
		} catch(EntityNotFoundException ex){
			author = new Author();
			//no entity found return empty object
		}
		return author;
	}
	
	@Override
	@Transactional
	public Author findByIdNotLazy(Integer authorId) {
		if(authorId == null || authorId == 0){
			return null;
		}
		Author author;
		try{
			author = authorRepository.getOne(authorId);
			if(!author.getBooks().isEmpty())
				author.getBooks().get(0).getIsbn();
		} catch(EntityNotFoundException ex){
			author = new Author();
			//no entity found return empty object
		}
		return author;
	}

	@Override
	/**
	 * returns 0 if could not delete it, 1 if could delete it
	 */
	public int delete(Integer authorId) {
		if(authorId == null || authorId == 0){
			return 0;
		}
		
		authorRepository.delete(authorId);
		return 1;
	}

	@Override
	public void saveOrEdit(Author author) {
		
		//TODO add some validations later maybe
		authorRepository.save(author);
		
	}
	
	

}
