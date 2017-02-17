package k3m.mx.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class BooksRepositoryImpl {
	
	@Autowired
	private BookRepository booksRepository;
	
}
