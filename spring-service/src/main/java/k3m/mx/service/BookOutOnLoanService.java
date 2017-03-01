package k3m.mx.service;

import k3m.mx.entities.BookOutOnLoan;

public interface BookOutOnLoanService {
	public BookOutOnLoan findById(Integer idBookBorrowing);
	
	public int delete(Integer idBookBorrowing);
	
	public void saveOrEdit(BookOutOnLoan bookOutOnLoan);

	public BookOutOnLoan findByIdNotLazy(Integer idBookBorrowing);
}
