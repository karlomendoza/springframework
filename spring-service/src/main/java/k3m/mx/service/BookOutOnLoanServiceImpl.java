package k3m.mx.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k3m.mx.entities.BookOutOnLoan;
import k3m.mx.repository.BookOutOnLoanRepository;

@Service("bookOutOnLoan")
public class BookOutOnLoanServiceImpl implements BookOutOnLoanService {

	@Autowired
	private BookOutOnLoanRepository boolRepository;
	
	@Override
	@Transactional
	public BookOutOnLoan findById(Integer idBookBorrowing) {
		if(idBookBorrowing == null || idBookBorrowing == 0){
			return null;
		}
		BookOutOnLoan bookOutOnLoan;
		try{
			bookOutOnLoan = boolRepository.getOne(idBookBorrowing);
			bookOutOnLoan.getIdBookBorrowing();
		} catch(EntityNotFoundException ex){
			bookOutOnLoan = new BookOutOnLoan();
			//no entity found return empty object
		}
		return bookOutOnLoan;
	}

	@Override
	@Transactional
	public BookOutOnLoan findByIdNotLazy(Integer idBookBorrowing) {
		if(idBookBorrowing == null || idBookBorrowing == 0){
			return null;
		}
		BookOutOnLoan bookOutOnLoan;
		try{
			bookOutOnLoan = boolRepository.getOne(idBookBorrowing);
			bookOutOnLoan.getIdBookBorrowing();
			bookOutOnLoan.getBook().getIsbn();
			bookOutOnLoan.getStudent().getIdStudent();
		} catch(EntityNotFoundException ex){
			bookOutOnLoan = new BookOutOnLoan();
			//no entity found return empty object
		}
		return bookOutOnLoan;
	}

	@Override
	/**
	 * returns 0 if can't delete, returns 1 otherwise
	 */
	public int delete(Integer idBookBorrowing) {
		if(idBookBorrowing == null || idBookBorrowing == 0){
			return 0;
		}
		
		boolRepository.delete(idBookBorrowing);
		return 1;
	}

	@Override
	public void saveOrEdit(BookOutOnLoan bookOutOnLoan) {
		boolRepository.save(bookOutOnLoan);
	}

}
