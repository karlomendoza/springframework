package k3m.mx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import k3m.mx.entities.BookOutOnLoan;

public interface BookOutOnLoanRepository extends JpaRepository<BookOutOnLoan, Integer> {

}
