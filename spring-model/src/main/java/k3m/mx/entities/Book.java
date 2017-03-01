package k3m.mx.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity(name="books")
public class Book {
	@Id
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="title")
	private String title;
	
	@Column(name="date_of_publication")
	private Date dateOfPublication;
	
	
	//TODO change it latter so it's a many to many relationship
	@OneToOne(cascade=CascadeType.REFRESH)
	@JoinTable(
			name="books_by_author",
			joinColumns = @JoinColumn( name="isbn"),
			inverseJoinColumns = @JoinColumn(name = "idAuthor")
	)
	private Author author;
	
	//TODO change it latter so it's a many to many relationship
	@OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
			name="books_by_category",
			joinColumns = @JoinColumn( name="isbn"),
			inverseJoinColumns = @JoinColumn(name = "idCategory")
	)
	private Category category;
	
	@OneToOne(mappedBy = "book", cascade=CascadeType.ALL)
	private BookOutOnLoan bookOutOnLoan;
	
	public Book(){
		
	}
	
	public Book(String isbn, String title, Date dateOfPublication){
		this.isbn = isbn;
		this.title = title;
		this.dateOfPublication = dateOfPublication;
	}
	
	@Override
	public String toString(){
		return String.format(
				"isbn[id=%s, title='%s', dateOfPublication='%s']",
				isbn, title, dateOfPublication);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfPublication == null) ? 0 : dateOfPublication.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (dateOfPublication == null) {
			if (other.dateOfPublication != null)
				return false;
		} else if (!dateOfPublication.equals(other.dateOfPublication))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDateOfPublication() {
		return dateOfPublication;
	}
	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BookOutOnLoan getBookOutOnLoan() {
		return bookOutOnLoan;
	}

	public void setBookOutOnLoan(BookOutOnLoan bookOutOnLoan) {
		this.bookOutOnLoan = bookOutOnLoan;
	}
}
