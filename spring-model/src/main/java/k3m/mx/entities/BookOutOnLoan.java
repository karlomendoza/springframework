package k3m.mx.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="books_out_on_loan")
public class BookOutOnLoan {
	
	@Id
	@Column(name="idBookBorrowing")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idBookBorrowing;
	
	@Column(name="data_issued")
	private Date dateIssued;
	
	@Column(name="data_due_for_return")
	private Date dateDueForReturn;
	
	@Column(name="data_returned")
	private Date dateReturned;
	
	@Column(name="amount_of_fine")
	private BigDecimal amountOfFine;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="borrowerStudent_id")
	private Student student;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="isbn")
	private Book book;
	
	public BookOutOnLoan(){
		
	}
	
	public BookOutOnLoan(Integer idBookBorrowing, Date dateIssued,
			Date dateDueForReturn, Date dateReturned, BigDecimal amountOfFine) {
		super();
		this.idBookBorrowing = idBookBorrowing;
		this.dateIssued = dateIssued;
		this.dateDueForReturn = dateDueForReturn;
		this.dateReturned = dateReturned;
		this.amountOfFine = amountOfFine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountOfFine == null) ? 0 : amountOfFine.hashCode());
		result = prime * result + ((dateDueForReturn == null) ? 0 : dateDueForReturn.hashCode());
		result = prime * result + ((dateIssued == null) ? 0 : dateIssued.hashCode());
		result = prime * result + ((dateReturned == null) ? 0 : dateReturned.hashCode());
		result = prime * result + ((idBookBorrowing == null) ? 0 : idBookBorrowing.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookOutOnLoan other = (BookOutOnLoan) obj;
		if (amountOfFine == null) {
			if (other.amountOfFine != null)
				return false;
		} else if (!amountOfFine.equals(other.amountOfFine))
			return false;
		if (dateDueForReturn == null) {
			if (other.dateDueForReturn != null)
				return false;
		} else if (!dateDueForReturn.equals(other.dateDueForReturn))
			return false;
		if (dateIssued == null) {
			if (other.dateIssued != null)
				return false;
		} else if (!dateIssued.equals(other.dateIssued))
			return false;
		if (dateReturned == null) {
			if (other.dateReturned != null)
				return false;
		} else if (!dateReturned.equals(other.dateReturned))
			return false;
		if (idBookBorrowing == null) {
			if (other.idBookBorrowing != null)
				return false;
		} else if (!idBookBorrowing.equals(other.idBookBorrowing))
			return false;
		return true;
	}

	public Integer getIdBookBorrowing() {
		return idBookBorrowing;
	}

	public void setIdBookBorrowing(Integer idBookBorrowing) {
		this.idBookBorrowing = idBookBorrowing;
	}

	public Date getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(Date dateIssued) {
		this.dateIssued = dateIssued;
	}

	public Date getDateDueForReturn() {
		return dateDueForReturn;
	}

	public void setDateDueForReturn(Date dateDueForReturn) {
		this.dateDueForReturn = dateDueForReturn;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public BigDecimal getAmountOfFine() {
		return amountOfFine;
	}

	public void setAmountOfFine(BigDecimal amountOfFine) {
		this.amountOfFine = amountOfFine;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
